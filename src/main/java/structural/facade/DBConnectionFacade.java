package structural.facade;

import java.sql.Connection;

// If the underlying protocol is getting complicated the facade wraps the classes and simplifies Client code

public class DBConnectionFacade {

    public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName){
        Connection con = null;
        switch (dbType){
            case MYSQL:
                con = MySQLHelper.getMySqlDBConnection();
                MySQLHelper mySqlHelper = new MySQLHelper();
                switch(reportType){
                    case HTML:
                        mySqlHelper.generateMySqlHTMLReport(tableName, con);
                        break;
                    case PDF:
                        mySqlHelper.generateMySqlPDFReport(tableName, con);
                        break;
                }
                break;
            case ORACLE:
                con = OracleHelper.getOracleDBConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch(reportType){
                    case HTML:
                        oracleHelper.generateOracleHTMLReport(tableName, con);
                        break;
                    case PDF:
                        oracleHelper.generateOraclePDFReport(tableName, con);
                        break;
                }
                break;
        }

    }

    public static enum DBTypes{
        MYSQL,ORACLE;
    }

    public static enum ReportTypes{
        HTML,PDF;
    }

}
