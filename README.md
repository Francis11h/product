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


## Enum

枚举类
![枚举类](https://github.com/Francis11h/product/blob/master/image/9.png)











