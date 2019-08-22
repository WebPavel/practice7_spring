一.前台模块
1.用户
    ①用户注册
    ②邮件激活
    ③用户登录
    ④用户退出
    ⑤用户修改个人信息
    ⑥我的订单
    ⑦评价晒单
2.分类
    ①一级分类列表(导航栏)
    ②二级分类列表
3.商品
    ①首页最新商品
    ②首页热门商品
    ③商品列表（分页）
    ④商品查询
    ⑤商品详情
    ⑥商品评价
4.购物车
    ①加入购物车（购物项）
    ②购物车详情
    ③修改购物项数量
    ④结算
    ⑤清空购物车
5.订单
    ①订单详情
    ②提交订单
    ③取消订单
    ④付款
    ⑤查看全部订单
6.支付
    ①支付宝支付
    ②微信支付
    ①跳转至银行支付
二.后台模块
1.用户管理
    ①查找用户
    ②修改用户（主要是状态）
    ③删除用户
2.分类管理
    2.1一级分类
        ①添加一级分类
        ②删除一级分类（级联删除二级分类）
        ③修改一级分类（状态）
    2.2二级分类
        ①查询二级分类
        ②添加二级分类
        ③修改二级分类
        ④删除二级分类（关联商品外键置空）
3.商品管理
    ①查询商品（分页、条件查询）
    ②添加商品（上传商品图片）
    ③修改商品（修改价格、商品图片）
    ④删除商品
4.订单管理
    ①查询订单（分页、条件查询、按状态查询）
    ②修改订单（状态）
    ③删除订单（将status置为1删除）

表结构：
用户表（用户id,用户名,密码,手机号码,昵称,邮箱,真实姓名,性别,出生日期,所在地区,详细地址,邮编,用户状态,激活码,创建时间）
一级分类表（一级分类id,一级分类名称,是否热门,状态,排序,创建时间）
二级分类表（二级分类id,二级分类名称,是否热门,状态,排序,创建时间,所属一级分类id）
商品表（商品id，商品名称,商场价,划线价,折扣,商品介绍,商品图片,库存,商品编号,条形码,品牌,产地,保质期,重量,是否热门,状态,排序,创建时间,所属二级分类id）
订单表（订单id,下单时间,送货地址,总重量,运费,订单总价,订单编号,成交时间,订单状态,所属用户id）
[virtual]购物项表（id,购买数量,小计,状态,创建时间,所属商品id,所属购物车id）
[virtual]购物车表（id,总计,创建时间,所属用户id,所属订单id）


BaseEntity:开启逻辑删除功能字段
    id varchar(64)
    status 状态(0正常 1删除 2停用) bit(2) not null

BaseEntityCrop:开启SaaS多租户功能字段
    corp_code 租户代码 varchar(64) not null
    corp_name 租户名称 varchar(100) not null

DataEntity:传统通用字段
    status 状态(0正常 1删除 2停用) bit(2) not null
    create_by 创建者 varchar(64) not null
    create_date 创建时间 datetime not null
    update_by 更新者 varchar(64) not null
    update_date 更新时间 datetime not null
    remarks 备注 varchar(500)
DataEntityNoStatus：无删除状态的通用字段
    create_by 创建者 varchar(64) not null
    create_date 创建时间 datetime not null
    update_by 更新者 varchar(64) not null
    update_date 更新时间 datetime not null
    remarks 备注 varchar(500)

TreeEntity：父子级树形结构通用字段
    parent_code 父级编号 varchar(64) not null
    parent_codes 所有父级编号 varchar(1000) not null
    tree_sort 本级排序号(升序) decimal(10) not null
    tree_sorts 所有级别排序号 varchar(1000) not null
    tree_leaf 是否最末级 bit(1) not null
    tree_level 层次级别 decimal(4) not null
    tree_names 全节点名 varchar(1000) not null

ExtendEntity:通用型8444扩展字段
    extend_s1 扩展String1 varchar(500)
    extend_s2
    extend_s3
    extend_s4
    extend_s5
    extend_s6
    extend_s7
    extend_s8

    extend_i1 扩展Integer1 decimal(19)
    extend_i2
    extend_i3
    extend_i4

    extend_f1 扩展Float1 decimal(19,4)
    extend_f2
    extend_f3
    extend_f4

    extend_d1 扩展Date1 datetime
    extend_d2

分模块开发module