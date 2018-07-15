package cn.wodesh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = {"classpath:datasource.properties"},encoding = "utf-8")
@Component("dataSoruceBean")
public class DataSoruceBean {
    @Value("${datasource.url}")
    private String dbUrl;
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;
    @Value("${datasource.driver-class-name}")
    private String driverClassName;
    @Value("${datasource.initialSize}")
    private int initialSize;
    @Value("${datasource.minIdle}")
    private int minIdle;
    @Value("${datasource.maxActive}")
    private int maxActive;
    @Value("${datasource.maxWait}")
    private int maxWait;
    @Value("${datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${datasource.validationQuery}")
    private String validationQuery;
    @Value("${datasource.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${datasource.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${datasource.testOnReturn}")
    private boolean testOnReturn;
    @Value("${datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${datasource.filters}")
    private String filters;
    @Value("${datasource.connectionProperties}")
    private String connectionProperties;
    /**filter配置*/
    @Value("${datasource.allow}")
    private String allow;
    @Value("${datasource.deny}")
    private String deny;
    @Value("${datasource.loginUsername}")
    private String loginUsername;
    @Value("${datasource.loginPassword}")
    private String loginPassword;
    @Value("${datasource.resetEnable}")
    private String resetEnable;

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public int getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public int getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public boolean getPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public void setPoolPreparedStatements(boolean poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }

    public int getMaxPoolPreparedStatementPerConnectionSize() {
        return maxPoolPreparedStatementPerConnectionSize;
    }

    public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getConnectionProperties() {
        return connectionProperties;
    }

    public void setConnectionProperties(String connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getDeny() {
        return deny;
    }

    public void setDeny(String deny) {
        this.deny = deny;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getResetEnable() {
        return resetEnable;
    }

    public void setResetEnable(String resetEnable) {
        this.resetEnable = resetEnable;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"dbUrl\":\"")
                .append(dbUrl).append('\"');
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"driverClassName\":\"")
                .append(driverClassName).append('\"');
        sb.append(",\"initialSize\":")
                .append(initialSize);
        sb.append(",\"minIdle\":")
                .append(minIdle);
        sb.append(",\"maxActive\":")
                .append(maxActive);
        sb.append(",\"maxWait\":")
                .append(maxWait);
        sb.append(",\"timeBetweenEvictionRunsMillis\":")
                .append(timeBetweenEvictionRunsMillis);
        sb.append(",\"minEvictableIdleTimeMillis\":")
                .append(minEvictableIdleTimeMillis);
        sb.append(",\"validationQuery\":\"")
                .append(validationQuery).append('\"');
        sb.append(",\"testWhileIdle\":")
                .append(testWhileIdle);
        sb.append(",\"testOnBorrow\":")
                .append(testOnBorrow);
        sb.append(",\"testOnReturn\":")
                .append(testOnReturn);
        sb.append(",\"poolPreparedStatements\":")
                .append(poolPreparedStatements);
        sb.append(",\"maxPoolPreparedStatementPerConnectionSize\":")
                .append(maxPoolPreparedStatementPerConnectionSize);
        sb.append(",\"filters\":\"")
                .append(filters).append('\"');
        sb.append(",\"connectionProperties\":\"")
                .append(connectionProperties).append('\"');
        sb.append(",\"allow\":\"")
                .append(allow).append('\"');
        sb.append(",\"deny\":\"")
                .append(deny).append('\"');
        sb.append(",\"loginUsername\":\"")
                .append(loginUsername).append('\"');
        sb.append(",\"loginPassword\":\"")
                .append(loginPassword).append('\"');
        sb.append(",\"resetEnable\":\"")
                .append(resetEnable).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
