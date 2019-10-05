package com.fun.project.service;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${classInfo.classComment}
 *
 * @author u-fun
 * @date ${.now?string('yyyy/MM/dd')}
 */
@Service
public class ${classInfo.className}ServiceImpl implements ${classInfo.className}Service {

	@Autowired
	private ${classInfo.className}Mapper ${classInfo.className?uncap_first}Mapper;

	/**
	 * 通过Id查询 ${classInfo.className}
	 */
	@Override
	public ${classInfo.className} select${classInfo.className}ById(long ${classInfo.conversionPrimaryKey}) {
		return ${classInfo.className?uncap_first}Mapper.select${classInfo.className}ById(${classInfo.conversionPrimaryKey});
	}

	/**
	 * 查询${classInfo.className}列表
	 */

	@Override
  	public List<${classInfo.className}> select${classInfo.className}List(${classInfo.className} ${classInfo.className?uncap_first},int pageNum,int pageSize){
		return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->${classInfo.className?uncap_first}Mapper.select${classInfo.className}List(${classInfo.className?uncap_first}));
 	}

	/**
     * 新增${classInfo.className}
     */
	@Override
	public int insert${classInfo.className}(${classInfo.className} ${classInfo.className?uncap_first}) {
		return ${classInfo.className?uncap_first}Mapper.insert${classInfo.className}(${classInfo.className?uncap_first});
	}

	/**
	 * 通过id删除${classInfo.className}
	 */
	@Override
	public int delete${classInfo.className}ById(long ${classInfo.conversionPrimaryKey}) {
		return ${classInfo.className?uncap_first}Mapper.delete${classInfo.className}ById(${classInfo.conversionPrimaryKey});
	}

	/**
	 * 通过id批量删除${classInfo.className}
	 */
	@Override
		public int delete${classInfo.className}ByIds(String ${classInfo.conversionPrimaryKey}s){
		return ${classInfo.className?uncap_first}Mapper.delete${classInfo.className}ByIds(Convert.toStrArray(${classInfo.conversionPrimaryKey}s));
	 }

	/**
	 * 修改${classInfo.className}信息
	 */
	@Override
	public int update${classInfo.className}(${classInfo.className} ${classInfo.className?uncap_first}) {
		return ${classInfo.className?uncap_first}Mapper.update${classInfo.className}(${classInfo.className?uncap_first});
	}

}
