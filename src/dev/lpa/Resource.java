package dev.lpa;

import java.util.concurrent.locks.ReadWriteLock;

public class Resource {
    boolean isAvailable = false;

    public void producer(ReadWriteLock lock){
        try{
            lock.readLock().lock();

            System.out.println("Read Lock acquired by thread : "+ Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.readLock().unlock();
            System.out.println("Read Lock acquired by thread : "+ Thread.currentThread().getName());
        }
    }

    public void consumer(ReadWriteLock lock){
        try{
            lock.writeLock().lock();
            isAvailable = true;
            System.out.println("Write Lock acquired by thread : "+ Thread.currentThread().getName());
            Thread.sleep(8000);
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.writeLock().unlock();
            System.out.println("Write Lock acquired by thread : "+ Thread.currentThread().getName());
        }
    }
}
