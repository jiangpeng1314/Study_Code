package service;

import java.io.IOException;

import pojo.Account;

public interface AccountService {
	/**
	 * 账号和密码不匹配
	 */
	final int ACCOUNT_PASSWORD_NOT_MATCH=1;
	/**
	 * 转账成功
	 */
	final int SUCCESS=0;
	/**
	 * 转账失败
	 */
	final int ERROR=-1;
	/**
	 * 账号和姓名不匹配
	 */
	final int ACCOUNT_NAME_NOT_MATCH=2;
	/**
	 * 账户余额不足
	 */
	final int ACCOUNT_BALANCE_NOT_ENOUGH=3;
	
	
	
	int transfer(Account accIn,Account accOut) throws IOException;

}
