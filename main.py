import collections
import json
import os
import re
from urllib.parse import quote

import requests
import requests.packages.urllib3

requests.packages.urllib3.disable_warnings()


class LCSpider:
    graph_url = 'https://leetcode-cn.com/graphql'
    user_agent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) ' \
                 'Chrome/77.0.3865.120 Safari/537.36'

    def __init__(self):
        self.session = requests.session()

        # ['0000-0099', '0100-0199', ..., '9900-9999']
        self.sub_folders = [str(i * 100).zfill(4) + '-' + str(i * 100 + 99).zfill(4) for i in range(100)]
        self.difficulty_mapper = dict(Easy='简单', Medium='中等', Hard='困难')

        self.result = []
        self.cookie = ''

    def get_question_detail(self, question_title_slug):
        """fetch question detail from lc's api"""
        form_data = {
            'operationName': 'globalData',
            'query': 'query globalData {\n  feature {\n    questionTranslation\n    subscription\n    signUp\n    '
                     'discuss\n    mockInterview\n    contest\n    store\n    book\n    chinaProblemDiscuss\n    '
                     'socialProviders\n    studentFooter\n    cnJobs\n    enableLsp\n    enableWs\n    '
                     'enableDebugger\n    enableDebuggerAdmin\n    enableDarkMode\n    tasks\n    '
                     'leetbook\n    __typename\n  }\n  userStatus {\n    isSignedIn\n    isAdmin\n    '
                     'isStaff\n    isSuperuser\n    isTranslator\n    isPremium\n    isVerified\n    '
                     'isPhoneVerified\n    isWechatVerified\n    checkedInToday\n    username\n    '
                     'realName\n    userSlug\n    groups\n    avatar\n    optedIn\n    '
                     'requestRegion\n    region\n    activeSessionId\n    permissions\n    notificationStatus {\n      '
                     'lastModified\n      numUnread\n      __typename\n    }\n    completedFeatureGuides\n    '
                     'useTranslation\n    accountStatus {\n      isFrozen\n      inactiveAfter\n      __typename\n    '
                     '}\n    __typename\n  }\n  siteRegion\n  chinaHost\n  websocketUrl\n  userBannedInfo {\n    '
                     'bannedData {\n      endAt\n      bannedType\n      __typename\n    }\n    __typename\n  }\n}\n',
            'variables': {}
        }
        headers = {
            'User-Agent': LCSpider.user_agent,
            'Connection': 'keep-alive',
            'Content-Type': 'application/json',
            'Referer': 'https://leetcode-cn.com/problems/' + question_title_slug,
            # lc-cn cookie here
            # 'cookie': ''
        }
        self.session.post(url=LCSpider.graph_url,
                          data=json.dumps(form_data),
                          headers=headers,
                          timeout=10,
                          verify=False)

        form_data = {
            'operationName': 'questionData',
            'variables': {
                'titleSlug': question_title_slug
            },
            'query': 'query questionData($titleSlug: String!) {\n  question(titleSlug: $titleSlug) {\n    '
                     'questionId\n    questionFrontendId\n    categoryTitle\n    boundTopicId\n    title\n    '
                     'titleSlug\n    content\n    translatedTitle\n    translatedContent\n    isPaidOnly\n    '
                     'difficulty\n    likes\n    dislikes\n    isLiked\n    similarQuestions\n    '
                     'contributors {\n      username\n      profileUrl\n      avatarUrl\n      __typename\n    '
                     '}\n    langToValidPlayground\n    topicTags {\n      name\n      slug\n      '
                     'translatedName\n      __typename\n    }\n    companyTagStats\n    codeSnippets {\n      '
                     'lang\n      langSlug\n      code\n      __typename\n    }\n    stats\n    hints\n    '
                     'solution {\n      id\n      canSeeDetail\n      __typename\n    }\n    status\n    '
                     'sampleTestCase\n    metaData\n    judgerAvailable\n    judgeType\n    mysqlSchemas\n    '
                     'enableRunCode\n    envInfo\n    book {\n      id\n      bookName\n      pressName\n      '
                     'source\n      shortDescription\n      fullDescription\n      bookImgUrl\n      '
                     'pressImgUrl\n      productUrl\n      __typename\n    }\n    isSubscribed\n    '
                     'isDailyQuestion\n    dailyRecordStatus\n    editorType\n    ugcQuestionId\n    style\n    '
                     'exampleTestcases\n    __typename\n  }\n}\n'
        }

        # get question detail
        resp = self.session.post(url=LCSpider.graph_url,
                                 data=json.dumps(form_data).encode('utf-8'),
                                 headers=headers,
                                 timeout=10,
                                 verify=False)
        res = resp.json()
        return res['data']['question']

    def get_all_questions(self):
        """fetch all question from lc's api"""
        headers = {
            'accept': 'application/json, text/javascript, */*; q=0.01',
            'content-type': 'application/json',
            'user-agent': LCSpider.user_agent,
            'x-requested-with': 'XMLHttpRequest',
            # lc cookie here
            # 'cookie': ''
        }
        resp = self.session.get(url='https://leetcode.com/api/problems/all/',
                                headers=headers,
                                allow_redirects=False,
                                timeout=10,
                                verify=False)
        questions = resp.json()['stat_status_pairs']

        for question in questions:
            question_title_slug = question['stat']['question__title_slug']
            try:
                question_detail = self.get_question_detail(question_title_slug)
            except:
                continue
            frontend_question_id = str(question['stat']['frontend_question_id']).zfill(4)
            no = int(frontend_question_id) // 100

            question_title_en = question['stat']['question__title']
            question_title_en = re.sub(r'[\\/:*?"<>|]', '', question_title_en).strip()

            if not question_detail:
                print(f'skip {frontend_question_id}. {question_title_en}')
                continue

            url_cn = f'https://leetcode-cn.com/problems/{question_title_slug}'
            url_en = f'https://leetcode.com/problems/{question_title_slug}'

            path_cn = f'/solution/{self.sub_folders[no]}/{frontend_question_id}.{quote(question_title_en)}/README.md'
            path_en = f'/solution/{self.sub_folders[no]}/{frontend_question_id}.{quote(question_title_en)}/README_EN.md'

            print(f'{frontend_question_id}. {question_title_en}')
            topic_tags = question_detail.get('topicTags')

            item = {
                'question_id': str(question['stat']['question_id']).zfill(4),
                'frontend_question_id': frontend_question_id,
                'paid_only': question['paid_only'],
                'paid_only_cn': question_detail.get('isPaidOnly'),
                # Shell Database Algorithms Concurrency
                'category': question_detail.get('categoryTitle'),
                'url_cn': url_cn,
                'url_en': url_en,
                'relative_path_cn': path_cn,
                'relative_path_en': path_en,
                'title_cn': question_detail.get('translatedTitle') or question_title_en or '',
                'title_en': question_title_en or '',
                'question_title_slug': question_title_slug,
                'content_en': question_detail.get('content'),
                'content_cn': question_detail.get('translatedContent') or question_detail.get('content'),
                'tags_en': [e['name'] for e in topic_tags if e['name']] or [],
                'tags_cn': [e['translatedName'] for e in topic_tags if e['translatedName']] or [],
                'difficulty_en': question_detail.get('difficulty'),
                'difficulty_cn': self.difficulty_mapper.get(question_detail.get('difficulty')),
                'code_snippets': question_detail.get('codeSnippets') or [],
            }

            col1_cn = f'[{frontend_question_id}]({url_cn})'
            col2_cn = f'[{item["title_cn"]}]({path_cn})' if item["title_cn"] else f'[{item["title_en"]}]({path_en})'
            col3_cn = ','.join([f'`{tag}`' for tag in item['tags_cn']])
            col3_cn = '' if (col3_cn == 'None' or not col3_cn) else col3_cn
            col4_cn = item['difficulty_cn']
            col5_cn = '🔒' if item['paid_only_cn'] else ''

            col1_en = f'[{frontend_question_id}]({url_en})'
            col2_en = f'[{item["title_en"]}]({path_en})'
            col3_en = ','.join([f'`{tag}`' for tag in item['tags_en']])
            col3_en = '' if (col3_en == 'None' or not col3_en) else col3_en
            col4_en = item['difficulty_en']
            col5_en = '🔒' if item['paid_only'] else ''

            item['md_table_row_cn'] = [col1_cn, col2_cn, col3_cn, col4_cn, col5_cn]
            item['md_table_row_en'] = [col1_en, col2_en, col3_en, col4_en, col5_en]

            self.result.append(item)

    def save_result(self):
        with open('result.json', 'w', encoding='utf-8') as f:
            f.write(json.dumps(self.result))

    @staticmethod
    def generate_readme():
        """generate readme files"""
        with open('./result.json', 'r', encoding='utf-8') as f:
            result = f.read()
            result = json.loads(result)

        md_table_cn = [item['md_table_row_cn'] for item in result]
        md_table_en = [item['md_table_row_en'] for item in result]

        # generate README.md
        items = []
        table_cn = '\n|  题号  |  题解  |  标签  |  难度  | 备注 |\n| --- | --- | --- | --- | --- |'
        for item in sorted(md_table_cn, key=lambda x: x[0]):
            items.append(f'\n|  {item[0]}  |  {item[1]}  |  {item[2]}  |  {item[3]}  |  {item[4]}  |')
        table_cn += ''.join(items)

        with open('./readme_template.md', 'r', encoding='utf-8') as f:
            readme_cn = f.read()
        with open('./README.md', 'w', encoding='utf-8') as f:
            f.write(readme_cn.format(table_cn))

        # generate README_EN.md
        items = []
        table_en = '\n|  #  |  Solution  |  Tags  |  Difficulty  |  Remark |\n| --- | --- | --- | --- | --- |'
        for item in sorted(md_table_en, key=lambda x: x[0]):
            items.append(f'\n|  {item[0]}  |  {item[1]}  |  {item[2]}  |  {item[3]}  |  {item[4]}  |')
        table_en += ''.join(items)

        with open('./readme_template_en.md', 'r', encoding='utf-8') as f:
            readme_en = f.read()
        with open('./README_EN.md', 'w', encoding='utf-8') as f:
            f.write(readme_en.format(table_en))

    def generate_question_readme(self):
        print('--------------------------')
        with open("result.json", 'r', encoding='utf-8') as f:
            type_set = collections.defaultdict(list)
            res = f.read()
            res = json.loads(res)
            for item in res:
                tags = item['tags_en']
                for tag in tags:
                    type_set[tag].append(item)

        with open('./problem_readme_template.md', 'r', encoding='utf-8') as f:
            readme_cn = f.read()
        with open('./sql_problem_readme_template.md', 'r', encoding='utf-8') as f:
            sql_readme_cn = f.read()
        with open('./bash_problem_readme_template.md', 'r', encoding='utf-8') as f:
            bash_readme_cn = f.read()
        # {"tag": [q1, q2], "tag": [q1, q3, q4]}

        for tag, questions in type_set.items():
            for question in questions:
                path = f'./{tag}/{question["frontend_question_id"]}.{question["title_en"]}'
                path = path.replace(":", " ")
                if os.path.isdir(path):
                    continue
                os.makedirs(path)
                # choose the readme template
                category = question['category']
                if category == 'Shell':
                    readme_template_cn = bash_readme_cn
                elif category == 'Database':
                    readme_template_cn = sql_readme_cn
                else:
                    readme_template_cn = readme_cn

                # generate lc-cn problem readme
                with open(f'{path}/README.md', 'w', encoding='utf-8') as f1:
                    f1.write(readme_template_cn.format(int(question['frontend_question_id']),
                                                       question["title_cn"],
                                                       question['url_cn'],
                                                       question['content_cn']))

    @staticmethod
    def generate_summary():
        """generate summary files"""
        summary_cn = ''
        summary_en = ''
        for file in os.listdir('./'):
            if os.path.isdir("./" + file) and file != '__pycache__':
                summary_cn += f'\n- {file}\n'
                summary_en += f'\n- {file}\n'
                for sub in os.listdir('./' + file):
                    sub = sub.replace('`', ' ')
                    enc = quote(sub)
                    summary_cn += f'  - [{sub}](/solution/{file}/{enc}/README.md)\n'
                    summary_en += f'  - [{sub}](/solution/{file}/{enc}/README_EN.md)\n'

        # generate summary.md
        with open('./summary.md', 'w', encoding='utf-8') as f:
            f.write(summary_cn)

        # generate summary_en.md
        with open('./summary_en.md', 'w', encoding='utf-8') as f:
            f.write(summary_en)

    def generate_company_questions(self):
        def get_hot_company_name():
            """fetch question detail from lc's api"""
            form_data = {
                'operationName': 'interviewHotCards',
                'query': 'query interviewHotCards {\n  interviewHotCards {\n    id\n    acRate\n  '
                         '  order\n    isFavorite\n    isPremiumOnly\n    numParticipants\n   '
                         ' numQuestionsAced\n    numQuestions\n    privilegeExpiresAt\n    company {\n  '
                         '    name\n      slug\n      imgUrl\n      __typename\n    }\n    jobsCompany {\n   '
                         '   name\n      jobPostingNum\n      isVerified\n      __typename\n    }\n  '
                         '  __typename\n  }\n}\n',
                'variables': {}
            }
            headers = {
                'User-Agent': LCSpider.user_agent,
                'Connection': 'keep-alive',
                'Content-Type': 'application/json',
                'Referer': 'https://leetcode.cn/company/',
                # lc-cn cookie here
                'cookie': self.cookie
            }
            res = self.session.post(url=LCSpider.graph_url,
                                    data=json.dumps(form_data),
                                    headers=headers,
                                    timeout=10,
                                    verify=False)

            res = res.json()
            company_names = []
            for v in res['data']['interviewHotCards']:
                if v['company']:
                    company_names.append((v['company']['slug'], v['company']['name']))
            self.company_names = company_names

        def get_company_questions_info():
            self.company_question_info = dict()
            for name_en, name_cn in self.company_names:
                form_data = {
                    'operationName': 'problemsetQuestionsDynamicInfos',
                    'query': 'query problemsetQuestionsDynamicInfos {\n  problemsetQuestionsDynamicInfos {\n   '
                             ' questionId\n    frequency\n    solutionNum\n    isFavor\n    status\n  '
                             '  __typename\n  }\n}\n',
                    'variables': {}
                }
                headers = {
                    'User-Agent': LCSpider.user_agent,
                    'Connection': 'keep-alive',
                    'Content-Type': 'application/json',
                    'Referer': 'https://leetcode.cn/company/' + name_en + '/problemset/',
                    # lc-cn cookie here
                    'cookie': self.cookie
                }
                res = self.session.post(url=LCSpider.graph_url,
                                        data=json.dumps(form_data),
                                        headers=headers,
                                        timeout=10,
                                        verify=False)
                res = res.json()
                qs_info = dict()
                for info in res['data']['problemsetQuestionsDynamicInfos']:
                    self.company_question_info[info['questionId']] = info

        def get_company_question():
            company_questions = list()
            for name_en, name_cn in self.company_names:
                """fetch question detail from lc's api"""
                print("--------generate " + name_en + " question-----------")
                form_data = {
                    'operationName': 'companyQuestions',
                    'query': 'query companyQuestions($slug: String!) {\n  companyTag(slug: $slug) {\n    frequencies\n   '
                             ' questions {\n      questionId\n      frequencyTimePeriod\n      __typename\n    }\n  '
                             '  __typename\n  }\n}\n',
                    'variables': {"slug": name_en}
                }
                headers = {
                    'User-Agent': LCSpider.user_agent,
                    'Connection': 'keep-alive',
                    'Content-Type': 'application/json',
                    'Referer': 'https://leetcode.cn/company/' + name_en + '/problemset/',
                    # lc-cn cookie here
                    'cookie': self.cookie
                }
                res = self.session.post(url=LCSpider.graph_url,
                                        data=json.dumps(form_data),
                                        headers=headers,
                                        timeout=10,
                                        verify=False)
                res = res.json()
                qs = list()
                for question in res['data']['companyTag']['questions']:
                    print("---generate " + name_en + " question:" + question['titleSlug'])
                    info = self.company_question_info.get(question['questionId'], None)
                    if not info:
                        continue
                    frequency = info['frequency']
                    freq_bar = str(round(info['freqBar'], 2)) + "%"
                    ac_rate = info['acRate']
                    slug = question['titleSlug']
                    qs.append({'slug': slug, 'frequency': frequency, 'freq_bar': freq_bar, 'ac_rate': ac_rate})
                company_questions.append({
                    'company_name_en': name_en,
                    'company_name_cn': name_cn,
                    'qs': qs
                })
            with open('company.json', 'w', encoding='utf-8') as f:
                f.write(json.dumps(company_questions))

        def generate_company_readme():
            with open('./result.json', 'r', encoding='utf-8') as f:
                result = json.loads(f.read())
                m = {item['question_title_slug']: item for item in result}
            with open('company.json', 'r', encoding='utf-8') as f:
                company_list = list(json.loads(f.read()))

            for v in company_list:
                name_en, name_cn, qs = v['company_name_en'], v['company_name_cn'], v['qs']
                company_readme_en_prefix = "# " + name_en + "\n\n"
                company_readme_cn_prefix = "# " + name_cn + "\n\n"
                items = []
                en_items = []
                for q in qs:
                    slug = q['slug']
                    data = m.get(slug)
                    if data is None:
                        continue
                    items.append(
                        f'- [{str(int(data["frontend_question_id"])) + ". " + data["title_cn"]}]({data["relative_path_cn"]}) (出题频率: {q["freq_bar"]} / 通过率: {q["ac_rate"]})')
                    en_items.append(
                        f'- [{str(int(data["frontend_question_id"])) + ". " + data["title_en"]}]({data["relative_path_en"]}) (freqBar:{q["freq_bar"]} / acRate: {q["ac_rate"]})')

                if items and en_items:
                    company_en = company_readme_en_prefix + "\n".join(en_items)
                    company_cn = company_readme_cn_prefix + "\n".join(items)
                    with open("Company/" + str.upper(name_en) + "_README.md", 'w', encoding='utf-8') as f:
                        f.write(company_cn)
                    with open("Company/" + str.upper(name_en) + "_README_EN.md", 'w', encoding='utf-8') as f:
                        f.write(company_en)

        # get_hot_company_name()
        # get_company_questions_info()
        # get_company_question()
        generate_company_readme()


if __name__ == '__main__':
    spider = LCSpider()
    # spider.get_all_questions()
    spider.generate_company_questions()
    # spider.save_result()
    # spider.generate_question_readme()
