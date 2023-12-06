//package org.example.app.thread.user;
//
//import org.example.app.controller.TokenController;
//import org.example.app.controller.UserController;
//import org.example.app.model.Token;
//import org.example.app.repository.TokenIdRepository;
//import org.example.app.util.Util;
//
//import java.time.LocalTime;
//import java.util.Iterator;
//import java.util.Map;
//
//public class LogoutPeriod extends Thread {
//    private static final int LOGOUT_PERIOD = 10000;
//
//    private static final int CHECK_PERIOD = 5000;
//
//    public void run() {
//        while(true){
//            scanAndRemoveInvalidTime();
//            Util.sleep(CHECK_PERIOD);
//        }
//    }
//
//    public void scanAndRemoveInvalidTime(){
//        Iterator<Map.Entry<String, Map<String, Object>>> iteratorTokens = TokenController.getInstance().getTokenIdMap().entrySet().iterator();
//        long currentTime = Util.convertTimeToSecond(LocalTime.now());
//        while (iteratorTokens.hasNext()) {
//            Map.Entry<String, Map<String, Object>> entry = iteratorTokens.next();
//            String timeId = TokenController.getInstance().getTIME();
//
//            long time = (Long) entry.getValue().get(timeId);
//            if (currentTime - time >= LOGOUT_PERIOD/1000) {
//                String token = entry.getKey();
//                iteratorTokens.remove();
//                System.out.println("Remove token: "+token);
//            }
//        }
//    }
//
//}