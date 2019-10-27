package core.service.impl;

import core.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.exam.db.domain.Choices;
import software.exam.db.domain.Collection;
import software.exam.db.domain.CollectionExample;
import software.exam.db.mapper.ChoicesMapper;
import software.exam.db.mapper.CollectionMapper;
import software.exam.db.mapper.QuestionsMapper;
import software.exam.db.model.dto.OnlineDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectionMapper collectionMapper;

    @Autowired
    QuestionsMapper questionsMapper;

    @Autowired
    ChoicesMapper choicesMapper;

    /**
     * 添加收藏
     * @param collection
     */
    @Override
    public int add(Collection collection,int uid) {
        int insert=0;
        boolean flag=true;
        CollectionExample collectionExample=new CollectionExample();
        CollectionExample.Criteria criteria=collectionExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Collection> collections = collectionMapper.selectByExample(collectionExample);
        for (Collection collection1:collections){
            Integer qid = collection1.getQid();
            if (collection.getQid()==qid&&collection.getUid()==uid){
                insert=1;
                flag=false;
                break;
            }else{
                flag=true;
            }
        }
        if (flag){
             insert= collectionMapper.insert(collection);
        }
        return insert;
    }

    /**
     * 取消收藏
     * @param qid
     */
    @Override
    public int cancelCollection(int qid,int uid) {
        CollectionExample collectionExample=new CollectionExample();
        CollectionExample.Criteria criteria=collectionExample.createCriteria();
        criteria.andQidEqualTo(qid);
        criteria.andUidEqualTo(uid);
        int i = collectionMapper.deleteByExample(collectionExample);
        return i;
    }

    @Override
    public List<OnlineDto> findCollection(int uid) {
        //根据用户id获取qid
        CollectionExample  collectionExample = new CollectionExample();
        CollectionExample.Criteria criteria=collectionExample.createCriteria();
        criteria.andUidEqualTo(uid);
        List<Collection> collections = collectionMapper.selectByExample(collectionExample);

        List<OnlineDto> onlineDtos = new ArrayList<OnlineDto>();
        //遍历qid根据题目id获取信息，封装OnlineDto类
        for (int i = 0; i <collections.size() ; i++) {
            Integer qid = collections.get(i).getQid();
            OnlineDto onlineDto = questionsMapper.selectAllByQid(qid);
            List<Choices> choices = choicesMapper.randChoiceById(qid);
            onlineDto.setChoices(choices);
            onlineDto.setCollection(true);
//
//            System.out.println(onlineDto.toString());
//            System.out.println("=================================");
            //将onlineDto类循环添加到List<>中
            onlineDtos.add(onlineDto);
//            System.out.println(onlineDtos.toString());

        }

        return onlineDtos;
    }

}
