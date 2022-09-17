package org.infinispan.test;

import org.infinispan.AdvancedCache;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.container.DataContainer;
import org.infinispan.distribution.MagicKey;
import org.infinispan.distribution.rehash.XAResourceAdapter;
import org.infinispan.manager.CacheContainer;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.remoting.transport.Address;
import org.infinispan.test.fwk.TestCacheManagerFactory;
import org.infinispan.test.fwk.TransportFlags;
import org.infinispan.transaction.impl.TransactionTable;
import org.infinispan.util.concurrent.locks.LockManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

/**
 * Base class for tests that operates on clusters of caches. The way tests
 * extending this class operates is:
 * 
 * <pre>
 *    1) created cache managers before tests start. The cache managers are only created once
 *    2) after each test method runs, the cache instances are being cleared
 *    3) next test method will run on same cacheManager instance. This way the test is much faster, as CacheManagers
 *       are expensive to create.
 * </pre>
 * 
 * If, however, you would like your cache managers destroyed after every <i>test
 * method</i> instead of the </i>test
 * class</i>, you could set the <tt>cleanup</tt> field to
 * {@link MultipleCacheManagersTest.CleanupPhase#AFTER_METHOD} in
 * your test's constructor. E.g.:
 * 
 * <pre>
 * <p/>
 * public void MyTest extends MultipleCacheManagersTest {
 *    public MyTest() {
 *       cleanup =  CleanupPhase.AFTER_METHOD;
 *    }
 * }
 * <p/>
 * </pre>
 * <p/>
 * Note that this will cause {@link #createCacheManagers()} to be called before
 * each method.
 *
 * @author Mircea.Markus@jboss.com
 */
public abstract class MultipleCacheManagersTest extends AbstractCacheTest {

    protected void assertNoTransactions(final String cacheName) {
        eventually("There are pending transactions!", new Condition() {
            @Override
            public boolean isSatisfied() throws Exception {
                for (Cache<?, ?> cache : caches(cacheName)) {
                    final TransactionTable transactionTable = TestingUtil.extractComponent(cache,
                            TransactionTable.class);
                    int localTxCount = transactionTable.getLocalTxCount();
                    int remoteTxCount = transactionTable.getRemoteTxCount();
                    if (localTxCount != 0 || remoteTxCount != 0) {
                        log.tracef("Local tx=%s, remote tx=%s, for cache %s ",
                                transactionTable.getLocalGlobalTransaction(),
                                transactionTable.getRemoteGlobalTransaction(), address(cache));
                        return false;
                    }
                }
                return true;
            }
        });
    }
}