package core.service.impl;

import core.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.exam.db.domain.Collection;
import software.exam.db.domain.CollectionExample;
import software.exam.db.mapper.CollectionMapper;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectionMapper collectionMapper;
    /**
     * 添加收藏
     * @param collection
     */
    @Override
    public int add(Collection collection) {
        int insert=0;
        boolean flag=false;
        CollectionExample collectionExample=new CollectionExample();
        CollectionExample.Criteria criteria=collectionExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Collection> collections = collectionMapper.selectByExample(collectionExample);
        for (Collection collection1:collections){
            Integer qid = collection1.getQid();
            if (collection.getQid()==qid){
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
    public int cancelCollection(int qid) {
        CollectionExample collectionExample=new CollectionExample();
        CollectionExample.Criteria criteria=collectionExample.createCriteria();
        criteria.andQidEqualTo(qid);
        int i = collectionMapper.deleteByExample(collectionExample);
        return i;
    }

}
