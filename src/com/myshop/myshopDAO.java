package com.myshop;

import java.util.ArrayList;



/*import ExamplePackage.ConnectionManager;
import ExamplePackage.UserBean;*/

import java.sql.*;

public class myshopDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static ArrayList<ProductCategoryBean> Productcategry() {

		// preparing some objects for connection
		Statement stmt = null;
		String ProdCatsearchQuery = "select Product_Category_Name,Product_Category_Image_url from Product_Category";

		ArrayList<ProductCategoryBean> pcbeanList = new ArrayList<ProductCategoryBean>();
		// System.out.println("Query: "+searchQuery);

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(ProdCatsearchQuery);

			while (rs.next()) {
				// Bean class should be defined locally. otherwise, only one item will be stored
				ProductCategoryBean pcbean = new ProductCategoryBean();
				pcbean.setProductCategoryName(rs.getString("Product_Category_Name"));
				pcbean.setProductCategoryImageURL(rs.getString("Product_Category_Image_url"));
				pcbeanList.add(pcbean);

			}
		}

		catch (Exception ex) {
			System.out.println("Connection DB filed " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return pcbeanList;

	}

	public static ArrayList<ProductsListBean> ProductsList(String ProductCat) {

		// preparing some objects for connection
		Statement stmt = null;
		String searchQuery = "SELECT p.Product_Name,p.Product_Image_url,p.Product_Price,pc.Product_Category_Name"
				+ "  FROM Product p" + "  join Product_Category pc on pc.Product_Category_ID=p.Product_Category_ID\r\n"
				+ "  where pc.Product_Category_Name='" + ProductCat + "';";

		System.out.println(searchQuery);
		ArrayList<ProductsListBean> prodbeanList = new ArrayList<ProductsListBean>();
		// String<char> x="10";
		// System.out.println("Query: "+searchQuery);

		try {
			// connect to DB s
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery); 
			while (rs.next()) {  
				// Bean class should be defined locally. otherwise, only one item will be stored
				ProductsListBean prodbean = new ProductsListBean();
				prodbean.setProductName(rs.getString("Product_Name"));
				prodbean.setProductImageURL(rs.getString("Product_Image_url"));
				prodbean.setProductPrice(rs.getString("Product_price"));
				prodbean.setProductCat(rs.getString("Product_Category_Name"));
				prodbeanList.add(prodbean);

			}
		}

		catch (Exception ex) {
			System.out.println("Connection DB filed " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return prodbeanList;

	}

	public static ArrayList<ProductsListBean> Search(String ProductName) {

		// preparing some objects for connection
		Statement stmt = null;
		String Query = "Select Product_Name,Product_Image_url,Product_price from Product where Product_Name like  '%"
				+ ProductName + "%';";

		System.out.println("Query: " + Query);

		ArrayList<ProductsListBean> user = new ArrayList<ProductsListBean>();

		try {
			// connect to DB s
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);

			while (rs.next()) {
				// Bean class should be defined locally. otherwise, only one item will be stored
				ProductsListBean prodbean = new ProductsListBean();
				prodbean.setProductName(rs.getString("Product_Name"));
				prodbean.setProductImageURL(rs.getString("Product_Image_url"));
				prodbean.setProductPrice(rs.getString("Product_price"));
				user.add(prodbean);

			}
		}

		catch (Exception ex) {
			System.out.println("Connection DB filed " + ex);
		}

//some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
		return user;

	}

	public static ArrayList<ProductsListBean> ProductDetails(String ProductName) {
		Statement stmt = null;
		String searchQuery = "select  Product_Name,Product_Image_url,Product_Price  from Product WHERE Product_Name='"
				+ ProductName + "';";
		System.out.println(searchQuery);
		ArrayList<ProductsListBean> prodbeanList = new ArrayList<ProductsListBean>();
		try

		{
			// connect to DB s
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);

			while (rs.next()) {
				// Bean class should be defined locally. otherwise, only one item will be stored
				ProductsListBean prodbean = new ProductsListBean();
				prodbean.setProductName(rs.getString("Product_Name"));
				prodbean.setProductImageURL(rs.getString("Product_Image_url"));
				prodbean.setProductPrice(rs.getString("Product_price"));
				// prodbean.setProductCat(rs.getString("Product_Category_Name"));
				prodbeanList.add(prodbean);

			}
		} catch (Exception ex) {
			System.out.println("Connection DB filed " + ex);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return prodbeanList;

	}

	public static ArrayList<ProductsListBean> AddToCartTable(String ProductName) {

		// preparing some objects for connection
		Statement stmt = null;
		String searchQuery = "SELECT Product_Name,Product_Image_url,Product_price\r\n"
				+ "  FROM Product   where Product_Name like '%" + ProductName + "%';";

		System.out.println(searchQuery);
		ArrayList<ProductsListBean> prodbeanList = new ArrayList<ProductsListBean>();
//  System.out.println("Query: "+searchQuery);

		try {
			// connect to DB s
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);

			while (rs.next()) {
				// Bean class should be defined locally. otherwise, only one item will be stored
				ProductsListBean prodbean = new ProductsListBean();
				prodbean.setProductName(rs.getString("Product_Name"));
				prodbean.setProductImageURL(rs.getString("Product_Image_url"));
				prodbean.setProductPrice(rs.getString("Product_price"));
				prodbeanList.add(prodbean);

			}
		}

		catch (Exception ex) {
			System.out.println("Connection DB filed " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return prodbeanList;

	}

	public static void AddToCart(String productName, String quantity, String productPrice, String currentSession) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		int DBQuantity = 0;
		String DBPrice = null;

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			System.out.println(stmt);
			String SelectQuery = "select Quantity,Product_Price from Cart Where CurrentSession='" + currentSession
					+ "' and Product_Name='" + productName + "';";
			rs = stmt.executeQuery(SelectQuery);

			while (rs.next()) {
				DBQuantity = rs.getInt("Quantity");
				DBPrice = rs.getString("Product_Price");

			}
			if (DBQuantity == 0) {

				int Totalprice = Integer.parseInt(quantity) * Integer.parseInt(productPrice);

				String InsertQuery = "insert into Cart(currentSession,Product_Name,Quantity,Product_Price,Total_Price) values ('"
						+ currentSession + "','" + productName + "','" + quantity + "','" + productPrice + "','"
						+ Totalprice + "')";

				System.out.println("Query: " + InsertQuery);

				stmt.executeUpdate(InsertQuery);
				System.out.println("sucessfully inserted dta into" + stmt);
			} else {
				int FinalQuantity = DBQuantity + Integer.parseInt(quantity);
				int FianlTotalprice = FinalQuantity * Integer.parseInt(productPrice);
				String UpdateQuery = " Update  Cart set Quantity=" + FinalQuantity + " ,Total_price=" + FianlTotalprice
						+ " Where CurrentSession='" + currentSession + "' and Product_Name='" + productName + "';";
				System.out.println("Query: " + UpdateQuery);

				stmt.executeUpdate(UpdateQuery);
				System.out.println("sucessfully inserted dta into" + stmt);

			}

		}

		catch (Exception ex) {
			System.out.println("Connection DB filed " + ex);
		}

//some exception handling
		finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;

			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
	}

	public static ArrayList<ProductsListBean> ViewCart(String currentSession) {
		Statement stmt = null;
		/*
		 * String searchQuery =
		 * "SELECT  c.Cart_ID,c.CurrentSession,c.Product_Name,c.Quantity,c.Product_price,c.Total_price,p.Product_Image_url FROM Cart c join Product p on p.Product_ID=c.CurrentSession where c.CurrentSession='"
		 * + currentSession + "';";
		 */
		/*
		 * String searchQuery =
		 * "select  Cart_ID,CurrentSession,Product_Name,Quantity,Product_price,Total_price from Cart WHERE CurrentSession ='"
		 * + currentSession + "';";
		 */
		String searchQuery = "SELECT  c.Cart_ID,c.CurrentSession,c.Product_Name,c.Quantity,c.Product_price,c.Total_price,p.Product_Image_url "
				+ "FROM Cart c join Product p on p.Product_Name=c.Product_Name where c.CurrentSession ='"
				+ currentSession + "';";
		System.out.println(searchQuery);
		ArrayList<ProductsListBean> prodbeanList = new ArrayList<ProductsListBean>();
		try

		{
			// connect to DB s
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);

			while (rs.next()) {
				// Bean class should be defined locally. otherwise, only one item will be stored
				ProductsListBean prodbean = new ProductsListBean();
				prodbean.setCurrentSession(rs.getString("CurrentSession"));
				prodbean.setCart_ID(rs.getString("Cart_ID"));
				prodbean.setProductName(rs.getString("Product_Name"));
				// prodbean.setProductImageURL(rs.getString("Product_Image_url"));
				prodbean.setProductImageURL(rs.getString("Product_Image_url"));
				prodbean.setQuantity(rs.getString("Quantity"));
				prodbean.setProductPrice(rs.getString("Product_price"));
				prodbean.setTotal_price(rs.getString("Total_price"));

				// prodbean.setProductCat(rs.getString("Product_Category_Name"));
				prodbeanList.add(prodbean);

			}
		} catch (Exception ex) {
			System.out.println("Connection DB filed " + ex);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return prodbeanList;

	}

	public static void DeleteCart(String productName) {
		Statement stmt = null;

		String DeleteQuery = "delete from Cart where Product_Name='" + productName + "';";

		System.out.println("Query: " + DeleteQuery);

		try {
			// connect to DB s
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			System.out.println(stmt);

			stmt.executeUpdate(DeleteQuery);
			System.out.println("sucessfully deleted data" + stmt);

		}

		catch (Exception ex) {
			System.out.println("Connection DB filed " + ex);
		}

//some exception handling
		finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
	}

	public static  boolean  Checkout(String CurrentSession ) {
		Statement stmt = null;
		boolean itemsexist = false;
		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			System.out.println(stmt);
			

			String Query = "Select count(Quantity) from Cart where user_id is null and CurrentSession = '"
					+ CurrentSession + "';";
			System.out.println("\nYour CurrentSession is " + CurrentSession);
			System.out.println("Query: " + Query);
			
			
			rs = stmt.executeQuery(Query);

			
			while (rs.next()) {

				itemsexist = true;
				System.out.println(rs.getString(1));
			}
				/*String UpdateQuery = "UPDATE Cart SET User_logged = 'yes'where CurrentSession = '" + CurrentSession + "';";
				System.out.println("Query: " + UpdateQuery);

				stmt.executeUpdate(UpdateQuery);
				System.out.println("sucessfully updated" + stmt);*/

			
			if (itemsexist) {
				String UpdateQuery = "UPDATE Cart SET User_logged = 'yes'where CurrentSession = '" + CurrentSession + "';";
			System.out.println("Query: " + UpdateQuery);

			stmt.executeUpdate(UpdateQuery);
			System.out.println("sucessfully updated" + stmt);
			  
				
				
			} 
			/*else if (itemsexist) {
				System.out.println("Welcome " + CurrentSession);
				user.setCurrentSession(CurrentSession);
				user.setValid(true);
			}*/
			
			}
	
			catch (Exception ex) {
			System.out.println("Connection DB filed " + ex);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return itemsexist ;

	}

	public static UserBean login(UserBean bean, String CurrentSession) {
		Statement stmt = null;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			System.out.println(stmt);
			String username = bean.getUsername();
			String password = bean.getPassword();
			String firstName = null;
			String lastName = null;
			String User_logged1 ="No";
			String SelectQuery = "select distinct User_logged  from Cart  Where CurrentSession='" + CurrentSession + "';";
			System.out.println("Query: " + SelectQuery);
			rs = stmt.executeQuery(SelectQuery);
			System.out.println("sucessfully executed" + SelectQuery);
			while (rs.next()) {
				
				User_logged1 = rs.getString("user_logged");
			}
			
			String Query = "select * from ongs where username='" + username + "' AND password='" + password + "'";
			System.out.println("Your user name is " + username);
			System.out.println("Your password is " + password);
			System.out.println("Query: " + Query);
			rs = stmt.executeQuery(Query);
			boolean userexist = false;
			while (rs.next()) {
				userexist = true;
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				firstName = rs.getString("FirstName");
				lastName = rs.getString("LastName");
				/*bean.setUser_logged = rs.getString("user_logged");*/
			}
     if (!userexist) {
				       System.out.println("Sorry, you are not a registered user! Please sign up first");
				       bean.setValid(false);
			          }
    else if (userexist) {

			     	System.out.println("Welcome " + firstName);
				    bean.setFirstName(firstName);
				    bean.setLastName(lastName);
				    bean.setUser_logged(User_logged1);
				    bean.setValid(true);

			}
		}

		catch (Exception ex) {
			System.out.println("Exception  " + ex);
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return bean;

	}

	public static int save(ProductsListBean user) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			/* Connection con=EmpDao.getConnection(); */
			currentCon = ConnectionManager.getConnection();
			PreparedStatement ps = currentCon.prepareStatement(
					"insert into Product(Product_Name,Manufacturer,Product_Image_url,Product_Category_ID,Product_price) values (?,?,?,?,?)");
			System.out.println(ps);
			ps.setString(1, user.getProductName());
			ps.setString(2, user.getManufacturer());
			ps.setString(3, user.getProductImageURL());
			ps.setString(4, user.getProduct_Category_ID());
			ps.setString(5, user.getProductPrice());
			status = ps.executeUpdate();

			currentCon.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int NewUser(UserBean user) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			/* Connection con=EmpDao.getConnection(); */
			currentCon = ConnectionManager.getConnection();
			PreparedStatement ps = currentCon.prepareStatement(
					"insert into ongs(username,Password,FirstName,LastName,Gender,PhoneNumber,CurrentSession) values (?,?,?,?,?,?,?)");
			System.out.println(ps);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getGender());
			ps.setString(6, user.getPhoneNumber());
			ps.setString(7, user.getCurrentSession());
			status = ps.executeUpdate();

			currentCon.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static void UpdateCartUSer(String currentSession, String username) {
		// TODO Auto-generated method stub
		Statement stmt = null;

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			System.out.println(stmt);
			String UpdateQuery = " Update  Cart set User_ID = (select User_ID  from ongs where username='" + username
					+ "') Where CurrentSession='" + currentSession + "' ;";
			System.out.println("Query: " + UpdateQuery);
			stmt.executeUpdate(UpdateQuery);
			String Query = "UPDATE ongs SET User_logged = 'yes',CurrentSession = '" + currentSession + "' "
					+ " WHERE username = '" + username + "';";
			/*
			 * String Query="UPDATE ongs SET User_logged = 'yes',CurrentSession = '"+
			 * currentSession + "' ;";
			 */
			System.out.println("Query: " + Query);
			stmt.executeUpdate(Query);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static UserBean orderhistroy(String username1) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int save(UserBean user) {
		int status=0;
		try{
			currentCon = ConnectionManager.getConnection();
			PreparedStatement ps=currentCon.prepareStatement("insert into Orders(FullName,Email,Address,City,State,Zip) values (?,?,?,?,?,?)");
			System.out.println("insert query is "+ps);
			System.out.println(ps);
			ps.setString(1,user.getFullName());
			ps.setString(2,user.getEmail());
			ps.setString(3,user.getAddress());
			ps.setString(4,user.getCity());
			ps.setString(5,user.getState());
			ps.setString(6,user.getZip());
			
			status=ps.executeUpdate();
			
			currentCon.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	
	}
}
