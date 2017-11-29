/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaction;

import java.sql.*;

/**
 *
 * @author ligia
 */
public class Transaction {

  // connection data
  //static final String ODBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
  static final String ODBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DSN = "jdbc:mysql://localhost:3306/mydb";
  static final String USER = "root";
  static final String PWD = "1234";

  private Connection _conexao = null;
  private boolean _readOnly = false;

  public void begin() throws Exception{
      
      
      System.out.println("conexao1");
      Class.forName(ODBC_DRIVER);
      System.out.println("conexao2");
      _conexao = DriverManager.getConnection(DSN,USER,PWD);
      System.out.println("conexao3");
      _conexao.setAutoCommit(false);
	  _readOnly = false;
  } // begin

  public void beginReadOnly() throws Exception{
      
      Class.forName(ODBC_DRIVER).newInstance();
      
      _conexao = DriverManager.getConnection(DSN,USER,PWD);
	  _readOnly = true;
  } // begin

  public void commit() throws Exception {
      if ( !_readOnly) {
         _conexao.commit();
	  }
	  _conexao.close();
  } // commit

  public void rollback() throws Exception {
      if ( !_readOnly) {
         _conexao.rollback();
	  }
	  _conexao.close();
  } // rollback

  public Connection obterConexao() {
      return _conexao;
  } // obterConexao

} // Transacao
