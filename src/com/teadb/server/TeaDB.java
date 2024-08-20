package com.teadb.server;

import java.io.File;

import com.teadb.buffer.BufferMgr;
import com.teadb.file.FileMgr;
import com.teadb.log.LogMgr;
import com.teadb.tx.Transaction;

public class TeaDB {
	public static int BLOCK_SIZE = 400;
	public static int BUFFER_SIZE = 8;
	public static String LOG_FILE = "teadb.log";

	private FileMgr fm;
	private BufferMgr bm;
	private LogMgr lm;

	/**
	 * A constructor useful for debugging.
	 * 
	 * @param dirname   the name of the database directory
	 * @param blocksize the block size
	 * @param buffsize  the number of buffers
	 */
	public TeaDB(String dirname, int blocksize, int buffsize) {
		File dbDirectory = new File(dirname);
		fm = new FileMgr(dbDirectory, blocksize);
		lm = new LogMgr(fm, LOG_FILE);
		bm = new BufferMgr(fm, lm, buffsize);
	}

	/**
	 * A convenient way for clients to create transactions and access the metadata.
	 */
	public Transaction newTx() {
		return new Transaction(fm, lm, bm);
	}

	public FileMgr fileMgr() {
		return fm;
	}

	public LogMgr logMgr() {
		return lm;
	}

	public BufferMgr bufferMgr() {
		return bm;
	}
}
