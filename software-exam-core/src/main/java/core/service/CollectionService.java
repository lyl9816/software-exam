package core.service;

import software.exam.db.domain.Collection;

public interface CollectionService {
    /**
     * 添加收藏
     * @param collection
     */
   int add(Collection collection);

    /**
     * 取消收藏
     * @param qid
     */
    int cancelCollection(int qid);
}
