package persist;

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
							"	name varchar(40)" +
							"	brand varchar(40)," +
							"	series varchar(40)" +
							"	frequency varchar(40)," +
							"	cores varchar(40)" +
							"	url varchar(40)," +
							"	price varchar(40)" +
							"	sale varchar(40)," +
							")"
						);	
					stmt1.executeUpdate();
					stmt2 = conn.prepareStatement(
							"create table gpus (" +
							"	gpu_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	brand varchar(40)," +
							"	slottype varchar(40)" +
							"	gpubase varchar(40)," +
							"	memorysize varchar(40)" +
							"	url varchar(40)," +
							"	price varchar(40)" +
							"	sale varchar(40)," +
							")"
					);
					stmt2.executeUpdate();
					
					stmt3 = conn.prepareStatement(
							"create table motherboards (" +
							"	motherboard_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	brand varchar(40)," +
							"	model varchar(40)" +
							"	sockettype varchar(40)," +
							"	url varchar(40)" +
							"	price varchar(40)," +
							"	sale varchar(40)," +
							")"
					);
					stmt3.executeUpdate();
					
					
					
					stmt4 = conn.prepareStatement(
							"create table psus (" +
							"	psu_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	wattage varchar(40)," +
							"	brand varchar(40)" +
							"	url varchar(40)," +
							"	model varchar(40)" +
							"	price varchar(40)," +
							"	sale varchar(40)," +
							")"
					);
					stmt4.executeUpdate();
					
					
					
					stmt5 = conn.prepareStatement(
							"create table rams (" +
							"	ram_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	brand varchar(40)," +
							"	series varchar(40)" +
							"	model varchar(40)," +
							"	capacity varchar(40)" +
							"	type varchar(40)," +
							"	multichanneltype varchar(40)," +
							"	url varchar(40)," +
							"	price varchar(40)," +
							"	sale varchar(40)," +
							")"
					);
					stmt5.executeUpdate();
					
					
					stmt6 = conn.prepareStatement(
							"create table storages (" +
							"	storage_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +									
							"	capacity varchar(40)," +
							"	storagetype varchar(40)" +
							"	dataspeed varchar(40)," +
							"	url varchar(40)" +
							"	brand varchar(40)," +
							"	model varchar(40)," +
							"	price varchar(40)," +
							"	sale varchar(40)," +
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
		Connection conn = DriverManager.getConnection("jdbc:derby:C:/Users/rjones38/workspace/db.db;create=true");
		
		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}
	
	public CpuPart loadCpu(ResultSet r, int index) throws SQLException{
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
				
			return c;
	}
	
	public GpuPart loadGpu(ResultSet r, int index) throws SQLException{
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
				
			return g;
	}
	
	public MotherboardPart loadMotherboard(ResultSet r, int index) throws SQLException{
		MotherboardPart mb = new MotherboardPart(
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getDouble(index++),
				r.getDouble(index++)		
		);
				
			return mb;
	}
	
	public PowerSupplyPart loadPowerSupply(ResultSet r, int index) throws SQLException{
		PowerSupplyPart ps = new PowerSupplyPart(
				r.getInt(index++),
				r.getString(index++),
				r.getString(index++),
				r.getString(index++),
				r.getDouble(index++),
				r.getInt(index++)		
		);
				
			return ps;
	}
	
	public StoragePart loadStorage(ResultSet r, int index) throws SQLException{
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
				
			return s;
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
							"select * from CPU"
							
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
							"select * from GPU"
							
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
							"select * from Motherboard"
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
							"select * from PSU"
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<RamPart> findAllRam() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}


}
