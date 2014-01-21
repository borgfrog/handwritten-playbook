package models.services.Check;

import java.util.List;

import play.db.ebean.Model;
import play.libs.F.Option;
import scala.None;
import utils.ModelUtil;
import utils.OptionUtil;
import utils.PageUtil;
import models.entity.Check;
import models.services.Model.ModelService;
import models.setting.CheckYouSetting;

public class CheckModelService implements ModelService<Check> {
	
	public static CheckModelService use() {
		return new CheckModelService();
	}

	@Override
	public Option<Check> findById(Long id) {
		Option<Long> idOps = OptionUtil.apply(id);
		if (idOps.isDefined()) {
			Model.Finder<Long, Check> find = ModelUtil.getFinder(Check.class);
			return OptionUtil.apply(find.byId(id));
		}
		return OptionUtil.none();
	}

	@Override
	public Option<Check> save(Check entry) {
		Option<Check> entryOps = OptionUtil.apply(entry);
		if (entryOps.isDefined()) {
			entry.save();
			if (OptionUtil.apply(entry.getId()).isDefined()) {
				return OptionUtil.apply(entry);
			}
		}
		return OptionUtil.none();
	}

	@Override
	public Option<List<Check>> findWithPage(Integer pageSource) {
		Integer page = PageUtil.rightPage(pageSource);
		Model.Finder<Long, Check> find = ModelUtil.getFinder(Check.class);
		return OptionUtil.apply(find.order().asc("created").findPagingList(CheckYouSetting.LIMIT).getPage(page).getList());
	}

	public Option<Integer> getMaxPage() {
		Model.Finder<Long, Check> find = ModelUtil.getFinder(Check.class);
		return OptionUtil.apply(find.order().asc("created").findPagingList(CheckYouSetting.LIMIT).getTotalPageCount());
	}
}
