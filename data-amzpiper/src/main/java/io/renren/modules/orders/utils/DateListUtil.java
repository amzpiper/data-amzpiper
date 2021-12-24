package io.renren.modules.orders.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author guoyh
 */
public class DateListUtil {

    public static void main(String[] args) {
        System.out.println("获取一天内所有小时列表:");
        List<String> hourList = DateListUtil.getHours();
        for (String s : hourList) {
            System.out.print(s+",");
        }
        System.out.println();

        System.out.println("获取7天内所有日期:");
        List<String> daysOf7List = DateListUtil.getDaysOf7();
        for (String s : daysOf7List) {
            System.out.print(s+",");
        }
        System.out.println();

        System.out.println("获取当月所有日:");
        List<String> daysList = DateListUtil.getDays();
        for (String s : daysList) {
            System.out.print(s+",");
        }
        System.out.println();

        System.out.println("获取当年所有月份:");
        List<String> monthsList = DateListUtil.getMonths();
        for (String s : monthsList) {
            System.out.print(s+",");
        }
        System.out.println();
    }


    /**
     * 获取一天内所有小时列表
     * 0:00,1:00,2:00,3:00,4:00,5:00,6:00,7:00,8:00,9:00,10:00,11:00,12:00,13:00,14:00,15:00,16:00,17:00,18:00,19:00,20:00,21:00,22:00,23:00
     * @return
     */
    public static List<String> getHours() {
        Integer[] hours=new Integer[25];
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        for (int i = 0; i < 24; i++) {
            hours[i]=calendar.get(Calendar.HOUR_OF_DAY);
            calendar.add(Calendar.HOUR_OF_DAY, 1);
        }
        List<String> list  = new ArrayList<>();
        for (int i = 0; i < hours.length-1; i++) {
            list.add(hours[i].toString()+":00");
        }
        return list;
    }

    /**
     * 获取7天内所有日期
     *
     * @return
     */
    public static List<String> getDaysOf7() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> list  = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        for (int i = 0; i < 7; i++) {
            list.add(0,sdf.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        return list;
    }

    /**
     * 获取当月所有日
     *
     * @return
     */
    public static List<String> getDays() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //获得本月第一天
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        String firstDay = sdf.format(calendar.getTime());
        //获得本月最后一天
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        String lastDay = sdf.format(calendar.getTime());

        String DATE_PATTERN = "yyyy-MM-dd";
        Date dateBegin = parse(firstDay, DATE_PATTERN);
        Date dateEnd = parse(lastDay, DATE_PATTERN);

        List<String> lDate = new ArrayList<String>();
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd");
        lDate.add(sd.format(dateBegin));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dateBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dateEnd);
        // 测试此日期是否在指定日期之后
        while (dateEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(sd.format(calBegin.getTime()));
        }
        return lDate;
    }

    /**
     * 获取当年所有月份
     *
     * @return
     */
    public static List<String> getMonths() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获得本年第一天
        Date date = new Date();
        Calendar currCal=Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR,currCal.get(Calendar.YEAR));
        String firstDay = sdf.format(calendar.getTime());
        //获得本年最后一天
        calendar.clear();
        calendar.set(Calendar.YEAR,currCal.get(Calendar.YEAR));
        calendar.roll(Calendar.DAY_OF_YEAR,-1);
        String lastDay = sdf.format(calendar.getTime());

        ArrayList<String> result = new ArrayList<>();
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(parse(firstDay, "yyyy-MM"));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(parse(lastDay, "yyyy-MM"));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM");
        while (curr.before(max)) {
            result.add(sd.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    /**
     * 日期解析
     *
     * @param date    日期
     * @param pattern 格式，如：DateUtils.DATE_TIME_PATTERN
     * @return 返回Date
     */
    public static Date parse(String date, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(date);
        } catch (Exception e) {
        }
        return null;
    }


    /**
     * 补齐未达到7天的数据
     * <p>
     * @param orderList
     *
     * @return
     */
    public static List<Object> compareDaysOf7(List<Map<String, Object>> orderList) {
        if (orderList == null) {
            orderList = new ArrayList<Map<String, Object>>();
        }
        List<String> daysOf7 = DateListUtil.getDaysOf7();
        if (orderList.size() != daysOf7.size()) {
            int index = 0;
            for (String dayValue : daysOf7) {
                if(orderList.size() <= index){
                    Map<String, Object> newMap = new HashMap<>();
                    newMap.put("times", dayValue);
                    newMap.put("count", 0);
                    orderList.add(index, newMap);
                    index = index+1;
                    continue;
                }
                if (!dayValue.equals(orderList.get(index).get("times"))) {
                    Map<String, Object> newMap = new HashMap<>();
                    newMap.put("times", dayValue);
                    newMap.put("count", 0);
                    orderList.add(index, newMap);
                }
                index = index + 1;
            }
        }
        return getList(orderList);
    }

    /**
     * 补齐未达到1个月的数据
     * <p>
     * @param orderList
     *
     * @return
     */
    public static List<Object> compareMonths(List<Map<String, Object>> orderList) {
        if (orderList == null) {
            orderList = new ArrayList<Map<String, Object>>();
        }
        List<String> daysList = DateListUtil.getDays();
        if (orderList.size() != daysList.size()) {
            int index = 0;
            for (String dayValue : daysList) {
                if(orderList.size() <= index){
                    Map<String, Object> newMap = new HashMap<>();
                    newMap.put("times", dayValue);
                    newMap.put("count", 0);
                    orderList.add(index, newMap);
                    index = index+1;
                    continue;
                }
                if (!dayValue.equals(orderList.get(index).get("times"))) {
                    Map<String, Object> newMap = new HashMap<>();
                    newMap.put("times", dayValue);
                    newMap.put("count", 0);
                    orderList.add(index, newMap);
                }
                index = index + 1;
            }
        }
        return getList(orderList);
    }

    /**
     * 补齐未达到12个月的数据
     * <p>
     * @param orderList
     *
     * @return
     */
    public static List<Object> compareYears(List<Map<String, Object>> orderList) {
        if (orderList == null) {
            orderList = new ArrayList<Map<String, Object>>();
        }
        List<String> monthsList = DateListUtil.getMonths();
        if (orderList.size() != monthsList.size()) {
            int index = 0;
            for (String dayValue : monthsList) {
                if(orderList.size() <= index){
                    Map<String, Object> newMap = new HashMap<>();
                    newMap.put("times", dayValue);
                    newMap.put("count", 0);
                    orderList.add(index, newMap);
                    index = index+1;
                    continue;
                }
                if (!dayValue.equals(orderList.get(index).get("times"))) {
                    Map<String, Object> newMap = new HashMap<>();
                    newMap.put("times", dayValue);
                    newMap.put("count", 0);
                    orderList.add(index, newMap);
                }
                index = index + 1;
            }
        }
        return getList(orderList);
    }

    private static List<Object> getList(List<Map<String, Object>> orderList){
        List<Object> newList = new ArrayList<>();
        for(Map<String, Object> order:orderList){
            newList.add(order.get("count"));
        }
        return newList;
    }

    private static List<String> getMapList(Map<String, String> dateList){
        return new ArrayList<>(dateList.values());
    }
}
