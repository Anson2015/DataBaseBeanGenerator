
# DataBaseBeanGenerator
it's a simple tool which can generate a bean denpends on the database tables 

##1.1 20150923 (version 1.0)
1.edit the property file ,add packageName which is the java file's package name. 
2.make the java bean's private properties is the same order with the table'column in the database.
3.this version can support the postgersql.

##2.1 20150925 (version 2.0)
1.change the structure of the properties file
 * add jdbc driver path and driver name which means could load the jdbc driver dynamically.
 
2.expand the support of database. Until now it could support oracle,mysql,postgresql.

##2.2 20150926 (version 2.1)
1.change the structure of the properties file.
2 users could generator different bean in different packages in the same time;
