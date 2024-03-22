package com.example.sbredismysqlrbmqseckill.demos.scene;
// 给每个组分配不同的IP段，怎么设计一种结构使的快速得知IP是哪个组的?
import java.util.HashMap;
import java.util.Map;

public class IPGroupAssigner {
    private final Map<String[], String> ipGroupMap;

    public IPGroupAssigner() {
        this.ipGroupMap = new HashMap<>();
    }

    // 添加 IP 段范围和对应的组标识符到哈希表中
    public void addIPRange(String startIP, String endIP, String groupID) {
        ipGroupMap.put(new String[]{startIP, endIP}, groupID);
    }

    // 确定给定 IP 地址属于哪个组
    public String findGroup(String ip) {
        for (Map.Entry<String[], String> entry : ipGroupMap.entrySet()) {
            String[] range = entry.getKey();
            String groupID = entry.getValue();
            if (isInRange(ip, range[0], range[1])) {
                return groupID;
            }
        }
        return null; // 如果没有匹配的 IP 段范围，则返回 null
    }

    // 检查给定的 IP 是否在指定的范围内
    private boolean isInRange(String ip, String startIP, String endIP) {
        long ipLong = ipToLong(ip);
        long startIPLong = ipToLong(startIP);
        long endIPLong = ipToLong(endIP);
        return ipLong >= startIPLong && ipLong <= endIPLong;
    }

    // 将 IP 地址转换为长整型数字
    private long ipToLong(String ip) {
        String[] ipParts = ip.split("\\.");
        long result = 0;
        for (int i = 0; i < 4; i++) {
            result += Long.parseLong(ipParts[i]) << (24 - (8 * i));
        }
        return result;
    }

    public static void main(String[] args) {
        IPGroupAssigner assigner = new IPGroupAssigner();

        // 添加 IP 段范围和对应的组标识符
        assigner.addIPRange("192.168.1.1", "192.168.1.255", "Group A");
        assigner.addIPRange("10.0.0.1", "10.0.0.255", "Group B");

        // 确定给定 IP 地址属于哪个组
        String ip = "192.168.1.100";
        String group = assigner.findGroup(ip);
        if (group != null) {
            System.out.println("The IP " + ip + " belongs to group: " + group);
        } else {
            System.out.println("The IP " + ip + " does not belong to any group.");
        }
    }
}

