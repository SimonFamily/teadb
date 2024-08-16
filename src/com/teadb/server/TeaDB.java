package com.teadb.server;

import java.io.File;

import com.teadb.file.FileMgr;
import com.teadb.log.LogMgr;

public class TeaDB {
	public static int BLOCK_SIZE = 400;
	public static int BUFFER_SIZE = 8;
	public static String LOG_FILE = "teadb.log";

	private FileMgr fm;
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
	}

	public FileMgr fileMgr() {
		return fm;
	}

	public LogMgr logMgr() {
		return lm;
	}
}
