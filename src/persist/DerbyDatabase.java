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
import partPickerPC.PartInterface;
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
				PreparedStatement stmt8 = null;
				
				try{
					stmt1 = conn.prepareStatement(
							"create table cpus (" +
							"	cpu_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	sockettype varchar(200)," +
							"	name varchar(200)," +
							"	brand varchar(200)," +
							"	series varchar(200)," +
							"	frequency varchar(200)," +
							"	cores varchar(200)," +
							"	url varchar(200)," +
							"	price varchar(200)," +
							"	sale varchar(200)" +
							")"
						);	
					stmt1.executeUpdate();
					stmt2 = conn.prepareStatement(
							"create table gpus (" +
							"	gpu_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	brand varchar(200)," +
							"   model varchar(200)," +
							"	slottype varchar(200)," +
							"	gpubase varchar(200)," +
							"	memorysize varchar(200)," +
							"	url varchar(200)," +
							"	price varchar(200)," +
							"	sale varchar(200)" +
							")"
					);
					stmt2.executeUpdate();
					
					stmt3 = conn.prepareStatement(
							"create table motherboards (" +
							"	motherboard_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	brand varchar(200)," +
							"	model varchar(200)," +
							"	sockettype varchar(200)," +
							"	url varchar(200)," +
							"	price varchar(200)," +
							"	sale varchar(200)" +
							")"
					);
					stmt3.executeUpdate();
					
					
					
					/*stmt4 = conn.prepareStatement(
							"create table psus (" +
							"	psu_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	wattage varchar(200)," +
							"	brand varchar(200)," +
							"	url varchar(200)," +
							"	model varchar(200)," +
							"	price varchar(200)," +
							"	sale varchar(200)" +
							")"
					);
					stmt4.executeUpdate();
					*/
					
					
					
					stmt5 = conn.prepareStatement(
							"create table rams (" +
							"	ram_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	brand varchar(200)," +
							"	series varchar(200)," +
							"	model varchar(200)," +
							"	capacity varchar(200)," +
							"	type varchar(200)," +
							"	multichanneltype varchar(200)," +
							"	url varchar(200)," +
							"	price varchar(200)," +
							"	sale varchar(200)" +
							")"
					);
					stmt5.executeUpdate();
					
					
					/*stmt6 = conn.prepareStatement(
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
					
					
					stmt8 = conn.prepareStatement(
							"create table builds("
							+ "build_id interger primary key"
							+ "		generated always as identity (start with 1, increment by 1),"
							+ "userid(100)"
							+ "cpu(100),"
							+ "gpu(100),"
							+ "motherboard(100)"
							+ "ram(100),"
							+ "storage(100),"
							+ ")"
					);
					stmt8.executeUpdate();
					
					return true;
				}finally{
					DBUtil.closeQuietly(stmt1);
					
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(stmt4);
					DBUtil.closeQuietly(stmt5);
					DBUtil.closeQuietly(stmt6);
					DBUtil.closeQuietly(stmt7);
					DBUtil.closeQuietly(stmt8);
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
		Connection conn = DriverManager.getConnection("jdbc:derby:C:/Users/Ryan/workspace/db.db;create=true");
		
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
	
	@Override
	
	
	public List<PartInterface> findPriceRange(String partType, String lowerend, String higherend) {
		return executeTransaction(new Transaction<List<PartInterface>>(){

			@Override
			public List<PartInterface> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				try{
				if (partType.compareTo("cpu") == 0)
				{
					stmt = conn.prepareStatement(
							"select * from cpus " +
							" where price between ? and ?"
							
							);
					stmt.setString(1, lowerend);
					stmt.setString(2, higherend);
					List<PartInterface> result = new ArrayList<PartInterface>();
					resultSet = stmt.executeQuery();
					boolean found = false;

					while(resultSet.next()){
						found = true;
						
						result.add(loadCpu(resultSet,1));
					}
					return result;
				}
				else if (partType.compareTo("mb") == 0)
				{
					stmt = conn.prepareStatement(
							"select * from motherboards " +
							" where price between ? and ?"
							
							);
					stmt.setString(1, lowerend);
					stmt.setString(2, higherend);
					List<PartInterface> result = new ArrayList<PartInterface>();
					resultSet = stmt.executeQuery();
					boolean found = false;

					while(resultSet.next()){
						found = true;
						
						result.add(loadMotherboard(resultSet,1));
					}
					return result;
				}
				else if (partType.compareTo("gpu") == 0)
				{
					stmt = conn.prepareStatement(
							"select * from gpus " +
							" where price between ? and ?"
							
							);
					stmt.setString(1, lowerend);
					stmt.setString(2, higherend);
					List<PartInterface> result = new ArrayList<PartInterface>();
					resultSet = stmt.executeQuery();
					boolean found = false;

					while(resultSet.next()){
						found = true;
						
						result.add(loadGpu(resultSet,1));
					}
					return result;
				}
				else if (partType.compareTo("ram") == 0)
				{
					stmt = conn.prepareStatement(
							"select * from rams " +
							" where price between ? and ?"
							
							);
					stmt.setString(1, lowerend);
					stmt.setString(2, higherend);
					List<PartInterface> result = new ArrayList<PartInterface>();
					resultSet = stmt.executeQuery();
					boolean found = false;

					while(resultSet.next()){
						found = true;
						
						result.add(loadRam(resultSet,1));
						return result;
					}
				}
				else
				{

				}
				

					
			}
			
			finally{
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);

		}
				List<PartInterface> result = new ArrayList<PartInterface>();
				result = null;
				return result;
	}
		});
	}

	@Override
	public List<CpuPart> findAllCpusCrit(String socketType, String brand, String series, String frequency
			, String cores, String low, String high) {
		return executeTransaction(new Transaction<List<CpuPart>>(){
			
			@Override
			public List<CpuPart> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try{
					stmt = conn.prepareStatement(
							"select * from cpus " +
							" WHERE (? IS NULL OR sockettype = ?) and " +
							" (? IS NULL OR brand = ?) and " +
							" (? IS NULL OR series = ?) and " + 
							" (? IS NULL OR frequency = ?) and " +
							" (? IS NULL OR cores = ?) and " +
							" price between ? and ? "
							);
					stmt.setString(1, socketType);
					stmt.setString(2, socketType);
					stmt.setString(3, brand);
					stmt.setString(4, brand);
					stmt.setString(5, series);
					stmt.setString(6, series);
					stmt.setString(7, frequency);
					stmt.setString(8, frequency);
					stmt.setString(9, cores);
					stmt.setString(10, cores);
					stmt.setString(11, low);
					stmt.setString(12, high);
					List<CpuPart> result = new ArrayList<CpuPart>();
					resultSet = stmt.executeQuery();
					boolean found = false;
					while(resultSet.next()){
						found = true;
						
						result.add(loadCpu(resultSet,1));
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
	public List<MotherboardPart> findAllMbsCrit(String brand, String socketType, String low, String high) {
		return executeTransaction(new Transaction<List<MotherboardPart>>(){
			
			@Override
			public List<MotherboardPart> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try{
					stmt = conn.prepareStatement(
							"select * from motherboards " +
							" WHERE (? IS NULL OR brand = ?) and " +
							" (? IS NULL OR sockettype = ?) and " +
							" price between ? and ? "
							);
					stmt.setString(1, brand);
					stmt.setString(2, brand);
					stmt.setString(3, socketType);
					stmt.setString(4, socketType);
					stmt.setString(5, low);
					stmt.setString(6, high);
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
				ArrayList<GpuPart> gpuList;
				ArrayList<MotherboardPart> motherboardList;
				ArrayList<RamPart> ramList;
				try {
					System.out.print("OK!!!");
					Search.getThisTestThing();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cpuList = Search.getCpuList();
				System.out.println("oksasa");
				gpuList = Search.getGpuList();
				System.out.println("okokok");
				motherboardList = Search.getMotherList();
				ramList = Search.getRamList();
				
				

				PreparedStatement insertCpu= null;
				PreparedStatement insertGpu= null;
				PreparedStatement insertMotherboard= null;
				PreparedStatement insertRam= null;

				try {
					insertCpu = conn.prepareStatement("insert into cpus (sockettype, name, brand, series, frequency, cores, url, price, sale) values (?, ?, ?, ?, ? , ?, ?, ? , ?)");
					insertGpu = conn.prepareStatement("insert into gpus (brand, model, slottype, gpubase, memorysize, url, price, sale) values (?, ?, ?, ?, ? , ?, ?, ?)");
					insertMotherboard = conn.prepareStatement("insert into motherboards (brand, model, sockettype, url, price, sale) values (?, ?, ?, ?, ? , ?)");
					insertRam = conn.prepareStatement("insert into rams (brand, series, model, capacity, type, multichanneltype, url, price, sale) values (?, ?, ?, ?, ? , ?, ?, ? , ?)");
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
					
					for (GpuPart gpu : gpuList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertGpu.setString(1, gpu.getBrand());
						insertGpu.setString(2, gpu.getModel());
						insertGpu.setString(3,  gpu.getSlotType());
						insertGpu.setString(4, gpu.getGpuBase());
						insertGpu.setString(5, gpu.getMemorySize());
						insertGpu.setString(6,  gpu.getUrl());
						insertGpu.setDouble(7,  gpu.getPrice());
						insertGpu.setDouble(8, 0.0);

	
						insertGpu.addBatch();
					}
					
					for (MotherboardPart motherboard: motherboardList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertMotherboard.setString(1, motherboard.getBrand());
						insertMotherboard.setString(2,  motherboard.getModel());
						insertMotherboard.setString(3, motherboard.getSocketType());
						insertMotherboard.setString(4, motherboard.getUrl());
						insertMotherboard.setDouble(5,  motherboard.getPrice());
						insertMotherboard.setDouble(6, 0.0);
	
						insertMotherboard.addBatch();
					}
					
					for (RamPart ram : ramList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertRam.setString(1, ram.getBrand());
						insertRam.setString(2,  ram.getSeries());
						insertRam.setString(3, ram.getModel());
						insertRam.setString(4, ram.getCapacity());
						insertRam.setString(5,  ram.getType());
						insertRam.setString(6, ram.getMultichannelType());
						insertRam.setString(7, ram.getUrl());
						insertRam.setDouble(8,  ram.getPrice());
						insertRam.setDouble(9, 0.0);
	
						insertRam.addBatch();
					}
					insertCpu.executeBatch();
					insertGpu.executeBatch();
					insertMotherboard.executeBatch();
					insertRam.executeBatch();
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertCpu);
					DBUtil.closeQuietly(insertGpu);
					DBUtil.closeQuietly(insertMotherboard);
					DBUtil.closeQuietly(insertRam);
				}
			}
		});
	}



	@Override
	public List<GpuPart> findAllGpusCrit(String brand, String series, String slotType, String memorySize, String low,
			String high) {
return executeTransaction(new Transaction<List<GpuPart>>(){
			
			@Override
			public List<GpuPart> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try{
					stmt = conn.prepareStatement(
							"select * from gpus " +
							" WHERE (? IS NULL OR brand = ?) and " +
							" (? IS NULL OR gpubase = ?) and " +
							" (? IS NULL OR slottype = ?) and " +
							" (? IS NULL OR memorysize = ?) and " +
							" price between ? and ? "
							);
					stmt.setString(1, brand);
					stmt.setString(2, brand);
					stmt.setString(3, series);
					stmt.setString(4, series);
					stmt.setString(5, slotType);
					stmt.setString(6, slotType);
					stmt.setString(7, memorySize);
					stmt.setString(8, memorySize);
					stmt.setString(9, low);
					stmt.setString(10, high);
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
	public List<RamPart> findAllRamsCrit(String brand, String type, String capacity, String multichannel, String low, String high) {
return executeTransaction(new Transaction<List<RamPart>>(){
			
			@Override
			public List<RamPart> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try{
					stmt = conn.prepareStatement(
							"select * from rams " +
							" WHERE (? IS NULL OR brand = ?) and " +
							" (? IS NULL OR type = ?) and " +
							" (? IS NULL OR capacity = ?) and " +
							" (? IS NULL OR multichanneltype = ?) and " +
							" price between ? and ? "
							);
					stmt.setString(1, brand);
					stmt.setString(2, brand);
					stmt.setString(3, type);
					stmt.setString(4, type);
					stmt.setString(5, capacity);
					stmt.setString(6, capacity);
					stmt.setString(7, multichannel);
					stmt.setString(8, multichannel);
					stmt.setString(9, low);
					stmt.setString(10, high);
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


}
