package com.example.service;

import java.util.Set;

public interface SysResourceService {

    Set<String> selectUserPerms(Integer userId);

}
