package com.teadb.plan;

import com.teadb.parse.QueryData;
import com.teadb.tx.Transaction;

/**
 * The interface implemented by planners for 
 * the SQL select statement.
 *
 */
public interface QueryPlanner {
   
   /**
    * Creates a plan for the parsed query.
    * @param data the parsed representation of the query
    * @param tx the calling transaction
    * @return a plan for that query
    */
   public Plan createPlan(QueryData data, Transaction tx);
}

