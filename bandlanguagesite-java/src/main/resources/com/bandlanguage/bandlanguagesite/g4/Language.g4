grammar Language;
script: (stmt Dot?)+ ;
stmt: simpleStmt | complexStmt;
simpleStmt: subject_predicate_object_stmt |
            subject_predicate_attribute_object_stmt |
            subject_adverbial_predicate_attribute_object_stmt |
            subject_adverbial_predicate_complement_attribute_object_stmt |
            judgeStmt;
complexStmt: (adverbial Comma)? ifStmt | concurrentStmt;
subject_predicate_object_stmt: subject? predicate object;
subject_predicate_attribute_object_stmt: subject? predicate attribute object;
subject_adverbial_predicate_attribute_object_stmt: adverbial Comma subject? predicate attribute? object |
                                                   subject? adverbial predicate attribute? object;
subject_adverbial_predicate_complement_attribute_object_stmt: (adverbial Comma)? subject? predicate attribute? object complement|
                                                              subject? adverbial? predicate attribute? object complement;
ifStmt: If judgeStmt Comma Then simpleStmt (Comma Else simpleStmt)?;
concurrentStmt: simpleStmt Comma Concurrent simpleStmt;
judgeStmt: object comparator object | object isExist | object notExist | judgeStmt logic_operator judgeStmt;//
subject: Me | Identifier;
predicate: verb;
object: object With object |
        object Of object |
        Number | String | Identifier |
        noun;
attribute: adjective | String | Identifier | noun;
adverbial: place_adverbial | preposition_object;
complement: time_complement | direction;
place_adverbial: preposition object direction?;
preposition_object: place_adverbial? preposition attribute? object;
isExist: Exist;//
notExist: NotExist;//
time_complement: Number Quantifier? TimeUnit;
comparator: MoreThan | LessThan | Equals;
logic_operator: And | Or;
noun: Organization | Department | SubDepartment | Band | Position | Role | Member | Tool | MaxAuthority | MinAuthority | Deadline | Reader |
      Writer | Speaker | Worker | Administrator | Drama | File | Chatroom | SuperiorDepartment | ParentDepartment | ParentBand | SubBand |
      Authority | NewStaff | SeniorStaff;
verb: Establish | Join | Delete | Accept | Grant | Publish | Dispatch | SendMsg | Show | Edit | Disable | Enable | Appear | Have | Merge |
      Change | Set | Move | Revoke | CancelPub | Appoint;//
adjective: Incumbent | Leaved ;
preposition: At | Make | From;//
direction: Inside;


Organization: '机构';
Department: '部门';
ParentDepartment: '父部门';
SuperiorDepartment: '上级部门';
SubDepartment: '子部门' | '下级部门';
Band: '帮区';
ParentBand: '父帮区';
SubBand: '子帮区';
Position: '岗位';
Member: '成员';
Tool: '工具';
Role: '角色';
Authority: '权限';
Reader: '读者';
Writer: '写者';
Speaker: '言者';
Worker: '工者';
Administrator: '管理员';
Drama: '剧本';
File: '文档';
Chatroom: '消息板';
MaxAuthority: '最高权限' | '最大权限';
MinAuthority: '最小权限' | '最低权限';
Deadline: '有效期' | '有效时长';
NewStaff: '新员工';
SeniorStaff: '老员工';
Show: '显示' | '列出' | '查看';
Establish: '创建' | '新建' | '新增';
Join: '添加' | '加入' | '加入到' | '拉入' | '拉入到';
Revoke: '撤消' | '撤消掉';
Set: '设定';
Change: '更换' | '更换到';
Edit: '修改' | '修改为';
Delete: '移除' | '删除' | '剔除' | '去除' | '删掉';
Merge: '合并' | '合并为' | '合并到';
Move: '移动' | '移动到';
Appoint: '任命' | '安排';
Relieve: '免除';
Grant: '授予';
Disable: '停用';
Enable: '启用';
SendMsg: '发消息' | '通知';
Accept: '吸收' | '接纳';
Dispatch: '派遣到' | '分派到';
Publish: '发布' | '发布到' | '发布给';
CancelPub: '取消发布';
Exist: '存在';
NotExist: '不存在';
Appear: '出现' | '出现在' | '要出现在';
Have: '拥有' | '要拥有';



Incumbent: '在职的';
Leaved: '离职的';

Me: '我';


At: '在' | '于';
Make: '把' | '将' | '为' | '对' | '给';//
From: '从';
Quantifier: '个' | '次' | '条';
TimeUnit: '分钟' | '小时' | '天' | '月' | '年';
MoreThan: '大于' | '大于等于';
LessThan: '小于' | '小于等于';
Equals: '等于';
And: '且';
Or: '或';
Inside: '里' | '内' | '中';

With: '和';
Of: '的';

If: '如果' | '假如';
Then: '则' | '那么';
Concurrent: '同时' | '并';
Else: '否则';

Comma: ',' | '，';
Dot :'.'|'。';
Number :[0-9]+;
String: '‘' (.)*? '’';
Identifier: ([a-zA-Z0-9$_] | [\u4E00-\u9FA5])+;
Ws :[ \t\r\n]+ -> skip;
Comment :'//' ~[\r\n]* -> channel(HIDDEN);