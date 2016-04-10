package persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Parts.CpuPart;
import Parts.GpuPart;
import Parts.MotherboardPart;
import Parts.PowerSupplyPart;
import Parts.RamPart;
import Parts.StoragePart;

import partPickerPC.Search;
import partPickerPC.User;


public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}

	private static final int MAX_ATTEMPTS = 10; 
	
	
	
	
	public void createTables(){
		executeTransaction(new Transaction<Boolean>(){

			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;
				PreparedStatement stmt7 = null;
				
				try{
					stmt1 = conn.prepareStatement(
							"create table cpus (" +
							"	cpu_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	sockettype varchar(40)," +
							"	name varchar(40)," +
							"	brand varchar(40)," +
							"	series varchar(40)," +
							"	frequency varchar(40)," +
							"	cores varchar(40)," +
							"	url varchar(100)," +
							"	price varchar(40)," +
							"	sale varchar(40)" +
							")"
						);	
					stmt1.executeUpdate();
					/*stmt2 = conn.prepareStatement(
							"create table gpus (" +
							"	gpu_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	brand varchar(40)," +
							"	slottype varchar(40)," +
							"	gpubase varchar(40)," +
							"	memorysize varchar(40)," +
							"	url varchar(100)," +
							"	price varchar(40)," +
							"	sale varchar(40)" +
							")"
					);
					stmt2.executeUpdate();
					
					stmt3 = conn.prepareStatement(
							"create table motherboards (" +
							"	motherboard_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	brand varchar(40)," +
							"	model varchar(40)," +
							"	sockettype varchar(40)," +
							"	url varchar(100)," +
							"	price varchar(40)," +
							"	sale varchar(40)" +
							")"
					);
					stmt3.executeUpdate();
					
					
					
					stmt4 = conn.prepareStatement(
							"create table psus (" +
							"	psu_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	wattage varchar(40)," +
							"	brand varchar(40)," +
							"	url varchar(100)," +
							"	model varchar(40)," +
							"	price varchar(40)," +
							"	sale varchar(40)" +
							")"
					);
					stmt4.executeUpdate();
					
					
					
					stmt5 = conn.prepareStatement(
							"create table rams (" +
							"	ram_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	brand varchar(40)," +
							"	series varchar(40)," +
							"	model varchar(40)," +
							"	capacity varchar(40)," +
							"	type varchar(40)," +
							"	multichanneltype varchar(40)," +
							"	url varchar(100)," +
							"	price varchar(40)," +
							"	sale varchar(40)" +
							")"
					);
					stmt5.executeUpdate();
					
					
					stmt6 = conn.prepareStatement(
							"create table storages (" +
							"	storage_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	capacity varchar(40)," +
							"	storagetype varchar(40)," +
							"	dataspeed varchar(40)," +
							"	url varchar(100)," +
							"	brand varchar(40)," +
							"	model varchar(40)," +
							"	price varchar(40)," +
							"	sale varchar(40)" +
							")"
					);
					stmt6.executeUpdate();
					stmt7 = conn.prepareStatement(
							"create table users (" +
							"	user_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	username varchar(50)," +
							"	password varchar(20)" +
							")"
					);
					stmt7.executeUpdate();
					
					
					
					*/
					return true;
				}finally{
					DBUtil.closeQuietly(stmt1);
					
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(stmt4);
					DBUtil.closeQuietly(stmt5);
					DBUtil.closeQuietly(stmt6);
					DBUtil.closeQuietly(stmt7);
				}
				
			}
			
		});
	}
	
	
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:C:/Users/dreid3/workspace/db.db;create=true");
		
		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Success!");
	}
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}
	
	public CpuPart loadCpu(ResultSet r, int index) throws SQLException{
		int temp = index++;
		CpuPart c = new CpuPart(
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getDouble(index++),
				r.getDouble(index++)		
		);
				c.setCpuId(temp);
			return c;
	}



	
	public GpuPart loadGpu(ResultSet r, int index) throws SQLException{
		int temp = index++;
		GpuPart g = new GpuPart(
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getDouble(index++),
				r.getDouble(index++)		
		);
			g.setGpuId(temp);	
			return g;
	}
	
	public MotherboardPart loadMotherboard(ResultSet r, int index) throws SQLException{
		int temp = index++;
		MotherboardPart mb = new MotherboardPart(
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getDouble(index++),
				r.getDouble(index++)		
		);
			mb.setMoboId(temp);
			return mb;
	}
	
	public PowerSupplyPart loadPowerSupply(ResultSet r, int index) throws SQLException{
		int temp = index++;
		PowerSupplyPart ps = new PowerSupplyPart(
				r.getInt(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getDouble(index++),
				r.getInt(index++)		
		);
			ps.setPsuId(temp);	
			return ps;
	}
	public StoragePart loadStorage(ResultSet r, int index) throws SQLException{
		int temp = index++;
		StoragePart s = new StoragePart(
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getDouble(index++),
				r.getDouble(index++)		
		);
			s.setHddId(temp);	
			return s;
	}
	public RamPart loadRam(ResultSet r, int index) throws SQLException{
		int temp = index++;
		RamPart ram = new RamPart(
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getDouble(index++),
				r.getDouble(index++)		
		);
			ram.setRamId(temp);	
			return ram;
	}
	@Override
	public List<CpuPart> findAllCpus() {
		return executeTransaction(new Transaction<List<CpuPart>>(){

			@Override
			public List<CpuPart> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				try{
					stmt = conn.prepareStatement(
							"select * from cpus"
							
							);
					List<CpuPart> result = new ArrayList<CpuPart>();
					resultSet = stmt.executeQuery();
					boolean found = false;
					while(resultSet.next()){
						found = true;
						
						result.add(loadCpu(resultSet,1));
					}
					System.out.println( result.get(10).getUrl());
					return result;
					
			}
			
			finally{
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
		}
	}
		});
	}
	@Override
	public List<GpuPart> findAllGpus() {
		return executeTransaction(new Transaction<List<GpuPart>>(){

			@Override
			public List<GpuPart> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				try{
					stmt = conn.prepareStatement(
							"select * from gpus"
							
							);
					List<GpuPart> result = new ArrayList<GpuPart>();
					resultSet = stmt.executeQuery();
					boolean found = false;
					while(resultSet.next()){
						found = true;
						
						result.add(loadGpu(resultSet,1));
					}
					return result;
			}
			
			finally{
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
		}
	}
		});
	}


	@Override
	public List<MotherboardPart> findAllMobos() {
		return executeTransaction(new Transaction<List<MotherboardPart>>(){
			
			@Override
			public List<MotherboardPart> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try{
					stmt = conn.prepareStatement(
							"select * from motherboards"
							);
					List<MotherboardPart> result = new ArrayList<MotherboardPart>();
					resultSet = stmt.executeQuery();
					boolean found = false;
					while(resultSet.next()){
						found = true;
						
						result.add(loadMotherboard(resultSet,1));
					}
					return result;
				}
				
				finally{
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}


	@Override
	public List<PowerSupplyPart> findAllPSUs() {
		return executeTransaction(new Transaction<List<PowerSupplyPart>>(){
					
					@Override
					public List<PowerSupplyPart> execute(Connection conn) throws SQLException {
						PreparedStatement stmt = null;
						ResultSet resultSet = null;
						
						try{
							stmt = conn.prepareStatement(
									"select * from psus"
									);
							List<PowerSupplyPart> result = new ArrayList<PowerSupplyPart>();
							resultSet = stmt.executeQuery();
							boolean found = false;
							while(resultSet.next()){
								found = true;
								
								result.add(loadPowerSupply(resultSet,1));
							}
							return result;
						}
						
						finally{
							DBUtil.closeQuietly(resultSet);
							DBUtil.closeQuietly(stmt);
						}
					}
				});
	}


	@Override
	public List<StoragePart> findAllStorage() {
		return executeTransaction(new Transaction<List<StoragePart>>(){
			
			@Override
			public List<StoragePart> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try{
					stmt = conn.prepareStatement(
							"select * from storages"
							);
					List<StoragePart> result = new ArrayList<StoragePart>();
					resultSet = stmt.executeQuery();
					boolean found = false;
					while(resultSet.next()){
						found = true;
						
						result.add(loadStorage(resultSet,1));
					}
					return result;
				}
				
				finally{
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}


	@Override
	public List<RamPart> findAllRam() {
		return executeTransaction(new Transaction<List<RamPart>>(){
					
					@Override
					public List<RamPart> execute(Connection conn) throws SQLException {
						PreparedStatement stmt = null;
						ResultSet resultSet = null;
						
						try{
							stmt = conn.prepareStatement(
									"select * from rams"
									);
							List<RamPart> result = new ArrayList<RamPart>();
							resultSet = stmt.executeQuery();
							boolean found = false;
							while(resultSet.next()){
								found = true;
								
								result.add(loadRam(resultSet,1));
							}
							return result;
						}
						
						finally{
							DBUtil.closeQuietly(resultSet);
							DBUtil.closeQuietly(stmt);
						}
					}
				});
	}



	@Override
	public User findUser(final String username, final String password)  {
		return executeTransaction(new Transaction<User>() {
			@Override
			public User execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from users " +
							" where username = ? and password = ? " );
					stmt.setString(1, username);
					stmt.setString(2, password);
					
					User result = null;
					resultSet = stmt.executeQuery();
					
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						User user = new User();
						loadUser(user, resultSet, 1);
						result = user;
						
						
					}
					
					if (!found) {
						System.out.println("No authors were found in the database");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
					
	}
	
	private void loadUser(User user, ResultSet resultSet, int index) throws SQLException {
		user.setUserId(resultSet.getInt(index++));
		user.setName(resultSet.getString(index++));
		user.setPassword(resultSet.getString(index++));
}
	
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				ArrayList<CpuPart> cpuList;
				try {
					Search.getThisTestThing();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cpuList = Search.getCpuList();
				
				

				PreparedStatement insertCpu= null;

				try {
					insertCpu = conn.prepareStatement("insert into cpus (sockettype, name, brand, series, frequency, cores, url, price, sale) values (?, ?, ?, ?, ? , ?, ?, ? , ?)");
					for (CpuPart cpu : cpuList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertCpu.setString(1, cpu.getSocketType());
						insertCpu.setString(2,  cpu.getName());
						insertCpu.setString(3, cpu.getBrand());
						insertCpu.setString(4, cpu.getSeries());
						insertCpu.setString(5,  cpu.getFrequency());
						insertCpu.setString(6, cpu.getCores());
						insertCpu.setString(7, cpu.getUrl());
						insertCpu.setDouble(8,  cpu.getPrice());
						insertCpu.setDouble(9, 0.0);
	
						insertCpu.addBatch();
					}
					insertCpu.executeBatch();
					
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertCpu);
				}
			}
		});
	}


}
