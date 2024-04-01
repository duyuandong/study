1.synchronired 内置关键字 ；lock 是一个类
2.synchronired 无法获取锁的状态 ；lock 可以判断是否获取到锁 (lock.isLocked())
3.synchronired 会自动释放锁；lock需要手动,
4.synchronired 线程1(获得锁,阻塞)  线程2(等待,傻傻等) ； lock的tryLock()方法可以尝试获取锁而不是一直等待下去
5.synchronired 可重入锁、不可以中断，非公平 ；lock 可重入、可以判断锁，非公平（通过构造方法可自己设置）
6.synchronired 适合锁少量的代码块；lock适合锁大量的代码同步，比较灵活