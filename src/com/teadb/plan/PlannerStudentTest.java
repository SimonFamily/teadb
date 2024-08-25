package com.teadb.plan;

import com.teadb.query.Scan;
import com.teadb.server.TeaDB;
import com.teadb.tx.Transaction;

public class PlannerStudentTest {
   public static void main(String[] args) {
	  TeaDB db = new TeaDB("studentdb");
      Planner planner = db.planner();
      Transaction tx  = db.newTx();

      // part 1: Process a query
      String qry = "select sname, gradyear from student";
      Plan p = planner.createQueryPlan(qry, tx);
      Scan s = p.open();
      while (s.next())
         System.out.println(s.getString("sname") + " " +
               s.getInt("gradyear"));
      s.close();

      // part 2: Process an update command
      String cmd = "delete from STUDENT where MajorId = 30";
      int num = planner.executeUpdate(cmd, tx);
      System.out.println(num + " students were deleted");

      tx.commit();
   }
}
