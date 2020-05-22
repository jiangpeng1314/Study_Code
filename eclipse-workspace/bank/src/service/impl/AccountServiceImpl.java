package service.impl;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pojo.Account;
import pojo.Log;
import service.AccountService;
import util.MyBatisUtil;

public class AccountServiceImpl implements AccountService {

	@Override
	public int transfer(Account accIn, Account accOut) throws IOException {
//		InputStream is = Resources.getResourceAsStream("mybatis.xml");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//		SqlSession session = factory.openSession();
		SqlSession session=MyBatisUtil.getSession();
		Account accOutSelect = session.selectOne("mapper.AccountMapper.selByAccnoPwd", accOut);
		Log log=new Log();
		log.setAccOut(accOut.getAccno());
		log.setAccIn(accIn.getAccno());
		log.setMoney(accOut.getBalance());
		// 判断账号和密码是否匹配
		if (accOutSelect != null) {
			if (accOutSelect.getBalance() >= accOut.getBalance()) {
				// 判断账号和姓名是否匹配
				Account accInSelect = session.selectOne("mapper.AccountMapper.selByAccnoName", accIn);
				if (accInSelect != null) {
					//日志表记录
					int index = session.insert("mapper.LogMapper.insLog",log);

					accIn.setBalance(accOut.getBalance());
					accOut.setBalance(-accOut.getBalance());
					 index += session.update("mapper.AccountMapper.updBalanceByAccno", accOut);
					index += session.update("mapper.AccountMapper.updBalanceByAccno", accIn);
					if (index == 3) {
						session.commit();
						session.close();
						return SUCCESS;
					} else {
						session.rollback();
						session.close();
						return ERROR;
					}
				} else {
					return ACCOUNT_NAME_NOT_MATCH;
				}
			} else {
				return ACCOUNT_BALANCE_NOT_ENOUGH;
			}
		} else {
			return ACCOUNT_PASSWORD_NOT_MATCH;
		}

	}

}
