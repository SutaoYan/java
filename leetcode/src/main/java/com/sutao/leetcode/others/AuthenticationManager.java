package com.sutao.leetcode.others;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

//https://leetcode.cn/problems/design-authentication-manager/?envType=study-plan&id=programming-skills-basic&plan=programming-skills&plan_progress=43k6uue
public class AuthenticationManager {

    private int timeToLive;
    private HashMap<String, Integer> map = new HashMap<>();
    private TreeMap<Integer, String> treeMap = new TreeMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
        treeMap.put(currentTime + timeToLive, tokenId);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            int count = map.get(tokenId);
            if (count <= currentTime) {
                map.remove(tokenId);
                treeMap.remove(count);
                return;
            }
            treeMap.remove(count);
            map.put(tokenId, currentTime + timeToLive);
            treeMap.put(currentTime + timeToLive, tokenId);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        removeExpired(currentTime);
        return map.size();
    }


    private void removeExpired(int currentTime) {
        Iterator<Integer> iterator = treeMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (item <= currentTime) {
                map.remove(treeMap.get(item));
                iterator.remove();
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(5);

        authenticationManager.renew("aaa", 1); // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
        authenticationManager.generate("aaa", 2); // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
        System.out.println(authenticationManager.countUnexpiredTokens(6));
        authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
        authenticationManager.renew("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
        authenticationManager.renew("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
        System.out.println(authenticationManager.countUnexpiredTokens(15));
    }
}
