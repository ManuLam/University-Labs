public class DataAccessPolicyManager2
{
private int readerCount, writeCount;
private Semaphore mutexReadCount, mutexWriteCount;
private Semaphore wrt, rdr;

	public DataAccessPolicyManager2() {
	readerCount = 0;
	mutexReadCount = new Semaphore(1);
	mutexWriteCount = new Semaphore(1);
	wrt = new Semaphore(1);
	rdr = new Semaphore(1);
	}

	public void acquireReadLock() {
		
		rdr.acquire();
		mutexReadCount.acquire();
		readerCount = readerCount +1;
		if (readerCount == 1) // This is the first reader
		wrt.acquire();

		mutexReadCount.release();
		rdr.release();
	}

	public void releaseReadLock() {
		mutexReadCount.acquire();
		readerCount = readerCount -1;;
		if (readerCount == 0) wrt.release();
		mutexReadCount.release();
	}

	public void acquireWriteLock() {
		mutexWriteCount.acquire();
		writeCount = writeCount+1;
		if(writeCount == 1) rdr.acquire();

	mutexWriteCount.release();
	wrt.acquire();
}

	public void releaseWriteLock() {
		mutexWriteCount.acquire();
		writeCount = writeCount-1;
		if(writeCount == 0) rdr.release();

	mutexWriteCount.release();
	wrt.release();
	}
}
