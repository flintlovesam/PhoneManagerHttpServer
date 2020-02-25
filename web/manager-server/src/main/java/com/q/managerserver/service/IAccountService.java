package com.q.managerserver.service;

import com.q.entity.Account;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Create by Administrator on 2020/2/25 0025
 */

public interface IAccountService {

  Integer importAccount(List<Account> accountList);

  List<Account> getAccount(Integer number);
}
