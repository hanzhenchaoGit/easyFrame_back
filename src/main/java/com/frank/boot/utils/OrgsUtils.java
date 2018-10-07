package com.frank.boot.utils;

public class OrgsUtils {
    public static boolean isTopOrg(String orgs){
        boolean hasTopOrg = false;
        String [] userOrgs = orgs.split(",");
        for(String org : userOrgs){
            if(org.equals("1")){
                hasTopOrg = true;
            }
        }
        return hasTopOrg;
    }
}
