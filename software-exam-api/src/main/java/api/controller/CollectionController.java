package api.controller;

import api.utils.ResponseUtil;
import com.sun.xml.internal.bind.v2.TODO;
import core.service.CollectionService;
import core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.exam.db.domain.Collection;
import software.exam.db.domain.User;
import software.exam.db.model.dto.OnlineDto;

import java.util.List;

@RestController
public class CollectionController {
    @Autowired
    CollectionService collectionService;
    @Autowired
    UserService userService;

    /**
     * 收藏
     * @param qid
     * @param nickName
     * @return
     */
    @GetMapping("/collectionQuestions")
    public Object collection(int qid,String nickName){
        User user = userService.selectByNickName(nickName);
        System.out.println(user);
        Integer id = user.getId();
        Collection collection=new Collection();
        collection.setUid(user.getId());
        collection.setQid(qid);
        int add = collectionService.add(collection,id);
        if (add>0){
            return ResponseUtil.ok();
        }
        return ResponseUtil.fail();
    }

    /**
     * 取消收藏
     * @param qid
     * @return
     */
    @GetMapping("/cancelCollection")
    public Object cancelCollection(int qid,String nickName){
        User user = userService.selectByNickName(nickName);
        System.out.println(user);
        Integer id = user.getId();
        int i = collectionService.cancelCollection(qid,id);
        if (i>0){
            return ResponseUtil.ok();
        }
        return ResponseUtil.fail();
    }

    /**
     * 读取用户收藏列表
     * @param nickName
     * @return
     */
    @GetMapping("/findCollection")
    public Object findCollection(String nickName)
    {
        //根据用户姓名获取uid
        User user = userService.selectByNickName(nickName);
        Integer id = user.getId();
        List<OnlineDto> onlineDtoList = collectionService.findCollection(id);
        if(onlineDtoList.size()<0 && onlineDtoList==null)
        {
            return ResponseUtil.fail();
        }
        return ResponseUtil.ok(onlineDtoList);
    }


}
