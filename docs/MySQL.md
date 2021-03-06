# MySQL 学习记录

#### 1. mysql引擎以及各个引擎的作用区别？
* Innodb引擎
* Innodb引擎提供了对数据库ACID事务的支持，并且实现了SQL标准的四种隔离级别。
  该引擎还提供了行级锁和外键约束，它的设计目标是处理大容量数据库系统，
  它本身其实就是基于MySQL后台的完整数据库系统，mysql运行时Innodb会在内存中建立缓冲池，用于缓冲数据和索引。
  但是该引擎不支持FULLTEXT类型的索引，而且它没有保存表的行数，当SELECT COUNT(*) FROM TABLE时需要扫描全表。
  当需要使用数据库事务时，该引擎当然是首选。
  由于锁的粒度更小，写操作不会锁定全表，所以在并发较高时，使用Innodb引擎会提升效率。
  但是使用行级锁也不是绝对的，如果在执行一个SQL语句时MySQL不能确定要扫描的范围，InnoDB表同样会锁全表。
  
* MyIASM引擎
* 它没有提供对数据库事务的支持，也不支持行级锁和外键，
  因此当INSERT(插入)或UPDATE(更新)数据时即写操作需要锁定整个表，效率便会低一些。
  不过和Innodb不同，MyIASM中存储了表的行数，于是SELECT COUNT(*) FROM TABLE时只需要直接读取已经保存好的值而不需要进行全表扫描。
  如果表的读操作远远多于写操作且不需要数据库事务的支持，那么MyIASM也是很好的选择。
  
* 主要区别：
  1. MyIASM是非事务安全的，而InnoDB是事务安全的
  
  2. MyIASM锁的粒度是表级的，而InnoDB支持行级锁
  
  3. MyIASM支持全文类型索引，而InnoDB不支持全文索引
  
  4. MyIASM相对简单，效率上要优于InnoDB，小型应用可以考虑使用MyIASM
  
  5. MyIASM表保存成文件形式，跨平台使用更加方便
  
* 应用场景：
  1. MyIASM管理非事务表，提供高速存储和检索以及全文搜索能力，如果再应用中执行大量select操作，应该选择MyIASM
  2. InnoDB用于事务处理，具有ACID事务支持等特性，如果在应用中执行大量insert和update操作，应该选择InnoDB

#### 2. MySQL事务隔离级别详解?
* Read Uncommitted（读取未提交内容）
       在该隔离级别，所有事务都可以看到其他未提交事务的执行结果。本隔离级别很少用于实际应用，因为它的性能也不比其他级别好多少。读取未提交的数据，也被称之为脏读（Dirty Read）。
* Read Committed（读取提交内容）
       这是大多数数据库系统的默认隔离级别（但不是MySQL默认的）。它满足了隔离的简单定义：一个事务只能看见已经提交事务所做的改变。这种隔离级别 也支持所谓的不可重复读（Nonrepeatable Read），因为同一事务的其他实例在该实例处理其间可能会有新的commit，所以同一select可能返回不同结果。
* Repeatable Read（可重读）
       这是mysql的默认事务隔离级别，它确保同一事务的多个实例在并发读取数据时，会看到同样的数据行。不过理论上，这会导致另一个棘手的问题：幻读 （Phantom Read）。简单的说，幻读指当用户读取某一范围的数据行时，另一个事务又在该范围内插入了新行，当用户再读取该范围的数据行时，会发现有新的“幻影” 行。InnoDB和Falcon存储引擎通过多版本并发控制（MVCC，Multiversion Concurrency Control）机制解决了该问题。
* Serializable（可串行化） 
       这是最高的隔离级别，它通过强制事务排序，使之不可能相互冲突，从而解决幻读问题。简言之，它是在每个读的数据行上加上共享锁。在这个级别，可能导致大量的超时现象和锁竞争。
  1. 脏读(Drity Read)：某个事务已更新一份数据，另一个事务在此时读取了同一份数据，由于某些原因，前一个RollBack了操作，则后一个事务所读取的数据就会是不正确的。
  2. 不可重复读(Non-repeatable read):在一个事务的两次查询之中数据不一致，这可能是两次查询过程中间插入了一个事务更新的原有的数据。
  3. 幻读(Phantom Read):在一个事务的两次查询中数据笔数不一致，例如有一个事务查询了几列(Row)数据，而另一个事务却在此时插入了新的几列数据，先前的事务在接下来的查询中，就会发现有几列数据是它先前所没有的。
#### 3. 索引有哪些？分别有什么特点？

* 唯一索引：UNIQUE 
    例如：create unique index stusno on student（sno）；
    表明此索引的每一个索引值只对应唯一的数据记录，对于单列惟一性索引，这保证单列不包含重复的值。
    对于多列惟一性索引，保证多个值的组合不重复。

* 主键索引：primary key
    数据库表经常有一列或列组合，其值唯一标识表中的每一行。该列称为表的主键。
    在数据库关系图中为表定义主键将自动创建主键索引，主键索引是唯一索引的特定类型。
    该索引要求主键中的每个值都唯一。
    当在查询中使用主键索引时，它还允许对数据的快速访问。 

* 聚集索引（也叫聚簇索引）：cluster  
    在聚集索引中，表中行的物理顺序与键值的逻辑（索引）顺序相同。
    一个表只能包含一个聚集索引。
    如果某索引不是聚集索引，则表中行的物理顺序与键值的逻辑顺序不匹配。
    与非聚集索引相比，聚集索引通常提供更快的数据访问速度。

1. 表的主键、外键必须有索引；
2. 数据量超过300的表应该有索引；
3. 经常与其他表进行连接的表,在连接字段上应该建立索引；
4. 经常出现在Where子句中的字段,特别是大表的字段,应该建立索引；
5. 索引应该建在选择性高的字段上；
6. 索引应该建在小字段上,对于大的文本字段甚至超长字段,不要建索引；
7. 复合索引的建立需要进行仔细分析；尽量考虑用单字段索引代替：
8. 频繁进行数据操作的表,不要建立太多的索引；
9. 删除无用的索引,避免对执行计划造成负面影响；

* 1. B+树
    * 我们经常听到B+树就是这个概念，用这个树的目的和红黑树差不多，也是为了尽量保持树的平衡，当然红黑树是二叉树，但B+树就不是二叉树了，节点下面可以有多个子节点，数据库开发商会设置子节点数的一个最大值，这个值不会太小，所以B+树一般来说比较矮胖，而红黑树就比较瘦高了。
关于B+树的插入，删除，会涉及到一些算法以保持树的平衡，这里就不详述了。ORACLE的默认索引就是这种结构的。
如果经常需要同时对两个字段进行AND查询,那么使用两个单独索引不如建立一个复合索引，因为两个单独索引通常数据库只能使用其中一个，而使用复合索引因为索引本身就对应到两个字段上的，效率会有很大提高。
    2. 散列索引
    * 第二种索引叫做散列索引，就是通过散列函数来定位的一种索引，不过很少有单独使用散列索引的，反而是散列文件组织用的比较多。
散列文件组织就是根据一个键通过散列计算把对应的记录都放到同一个槽中，这样的话相同的键值对应的记录就一定是放在同一个文件里了，也就减少了文件读取的次数，提高了效率。
散列索引呢就是根据对应键的散列码来找到最终的索引项的技术，其实和B树就差不多了，也就是一种索引之上的二级辅助索引，我理解散列索引都是二级或更高级的稀疏索引，否则桶就太多了，效率也不会很高。
    3. 位图索引
    * 位图索引是一种针对多个字段的简单查询设计一种特殊的索引，适用范围比较小，只适用于字段值固定并且值的种类很少的情况，比如性别，只能有男和女，或者级别，状态等等，并且只有在同时对多个这样的字段查询时才能体现出位图的优势。
位图的基本思想就是对每一个条件都用0或者1来表示，如有5条记录，性别分别是男，女，男，男，女，那么如果使用位图索引就会建立两个位图，对应男的10110和对应女的01001,这样做有什么好处呢，就是如果同时对多个这种类型的字段进行and或or查询时，可以使用按位与和按位或来直接得到结果了。

B+树最常用，性能也不差，用于范围查询和单值查询都可以。特别是范围查询，非得用B+树这种顺序的才可以了。
HASH的如果只是对单值查询的话速度会比B+树快一点，但是ORACLE好像不支持HASH索引，只支持HASH表空间。
位图的使用情况很局限，只有很少的情况才能用，一定要确定真正适合使用这种索引才用（值的类型很少并且需要复合查询），否则建立一大堆位图就一点意义都没有了。