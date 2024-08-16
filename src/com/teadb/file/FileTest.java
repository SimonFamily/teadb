package com.teadb.file;

import java.io.File;

import com.teadb.server.TeaDB;

public class FileTest {
	public static void main(String[] args) {
		TeaDB db = new TeaDB("logtest", 400, 8);
		FileMgr fm = db.fileMgr();
		BlockId blk = new BlockId("testfile", 2);
		int pos1 = 88;

		Page p1 = new Page(fm.blockSize());
		p1.setString(pos1, "abcdefghijklm");
		int size = Page.maxLength("abcdefghijklm".length());
		int pos2 = pos1 + size;
		p1.setInt(pos2, 345);
		fm.write(blk, p1);

		Page p2 = new Page(fm.blockSize());
		fm.read(blk, p2);
		System.out.println("offset " + pos2 + " contains " + p2.getInt(pos2));
		System.out.println("offset " + pos1 + " contains " + p2.getString(pos1));
	}
}
