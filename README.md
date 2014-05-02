jdorm
=====

jdorm-1.0 发布，高性能的 hibernate 精简版本。qq群：287266712
文件Entity动态生成demo:
  public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1/fastsystem";
		String username = "client";
		String password = "client";
		String packageName = "com.web.template.entity";
		String destination="F:/Eclipse/templateworkplace/webtemplate/src";
		String readDatasource="dataSource";
		String writeDatasource="dataSource";
		PojoGenerator generator = new PojoGenerator(driver, url, username, password, packageName,destination,readDatasource,writeDatasource);
		generator.setPrefix("UUM_");
		generator.createDatabaseEntities();
	}
