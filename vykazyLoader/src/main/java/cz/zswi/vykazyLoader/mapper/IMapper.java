package cz.zswi.vykazyLoader.mapper;

import java.util.List;

import cz.zswi.vykazyLoader.model.Data;
import cz.zswi.vykazyLoader.model.OutData;

/**
 * Rozhrani mapperu
 *
 */
public interface IMapper {
	public List<OutData> map(List<Data> dataList) throws Exception;
}
