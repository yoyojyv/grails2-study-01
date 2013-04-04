/*

# datasource attributes

• driverClassName: This is the class name of the JDBC driver.
• username: This is the username used to establish a JDBC connection.
• password: This is the password used to establish a JDBC connection.
• url: This is the JDBC URL of the database.
• dbCreate: This specifies whether to autogenerate the database from the domain model.
• pooled: This specifies whether to use a pool of connections (it defaults to true).
• conf igClass: This is the class that you use to configure Hibernate.
• logSql: This setting enables SQL logging.
• dialect: This is a string or class that represents the Hibernate dialect used to communicate with the database.
*/
dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}


