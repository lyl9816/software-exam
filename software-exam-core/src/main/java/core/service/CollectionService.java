package core.service;

import software.exam.db.domain.Collection;
import software.exam.db.model.dto.OnlineDto;

import java.util.List;

public interface CollectionService {
    /**
     * 添加收藏
     * @param collection
     */
   int add(Collection collection,int id);

    /**
     * 取消收藏
     * @param qid
     */
    int cancelCollection(int qid,int id);

    /**
     * 读取收藏表
     * @param id
     * @return
     */
    List<OnlineDto> findCollection(int id);

}
