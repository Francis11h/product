# product

## 配置
![依赖截图](https://github.com/Francis11h/product/blob/master/image/1.png)
![具体怎么连接数据库](https://github.com/Francis11h/product/blob/master/image/2.png)


## controller
![列出目标](https://github.com/Francis11h/product/blob/master/image/6.png)

## dataobject
***@Data***      lombok插件引入的 可以不用写 getter setter
***@Entity***    表的映射注解 必写
***@Id***        主键
几个注解的使用

![注解使用](https://github.com/Francis11h/product/blob/master/image/3.png)
    
## repository


repository 接口 继承 JPA

JpaRepository<表名字, 主键的类型>

***public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>***
![-](https://github.com/Francis11h/product/blob/master/image/4.png)


## 单元测试

***@RunWith(SpringRunner.class)***      run测试的规定
***@SpringBootTest***                   

***@Autowired***   引入要用的 repository

private ProductInfoRepository productInfoRepository;
![单元测试](https://github.com/Francis11h/product/blob/master/image/5.png)


## service

接口类 具体的实现逻辑都在这里

![service](https://github.com/Francis11h/product/blob/master/image/7.png)

接口类的实现 impl

***@Autowired***   引入要用的 repository 
![serviceImpl](https://github.com/Francis11h/product/blob/master/image/8.png)

写完之后要测试 
![serviceTest](https://github.com/Francis11h/product/blob/master/image/10.png)


## Enum

枚举类
![枚举类](https://github.com/Francis11h/product/blob/master/image/9.png)




## View Object

这个package 我们 封装最后接口要用的数据 
http  返回的 最外层对象: 规定的是 code + msg + data
其中 data 用范型
![http 返回的 最外层对象](https://github.com/Francis11h/product/blob/master/image/11.png)

其中的 data 再用一个 VO类表示 ProductVO 
但是该类 还包含了 类目Category的信息 所以我们还要 再用一个VO
![](https://github.com/Francis11h/product/blob/master/image/12.png)

ProductInfoVO 是 ProductVO中 不含category的部分的数据封装 相当于 第三层
![](https://github.com/Francis11h/product/blob/master/image/13.png)




## 重新去完善 controller

***@RestController***  代表是 controller
***@RequestMapping***   最前面设置一个 url

***@Autowired***
***private ProductService productService;***
***@Autowired***  每引入一个 要写一次 autowired
***private CategoryService categoryService;***

把两个要用的service 注入

***@GetMapping("/list")***   get方法的url
![controller 1](https://github.com/Francis11h/product/blob/master/image/14.png)

**list.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList())**

![controller 2](https://github.com/Francis11h/product/blob/master/image/15.png)

![拼装数据](https://github.com/Francis11h/product/blob/master/image/16.png)




