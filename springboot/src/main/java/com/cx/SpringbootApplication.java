package com.cx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cx.mapper")//扫描mapper文件夹
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
/*
*
*  {
  "id": "dhu_cmse_1",
  "name": "王朝生",
  "title": "研究员",
  "degree": "博士",
  "phone": "13122525622",
  "email": "cswang@dhu.edu.cn",
  "address": "松江区人民北路2999号",
  "introduction": "王朝生 博士 研究员 高分子科学与工程系 硕士生导师 021-67792960；cswang@dhu.edu.cn；13122525621·研究方向:纤维成形机理及加工，聚合反应工程\n·荣誉获奖:\n获得国家科技进步二等奖1项，省部级科技进步奖6项。\n·学习及工作经历:\n1992.9－1996.7 中国纺织大学，化学纤维专业，本科\n1996.7－2001.7 东华大学（原中国纺织大学），材料学，硕博连读，工学博士\n2001.3—2005.8 东华大学环境学院环境科学系，讲师，副教授，",
  "direction": "纤维成形机理及加工，聚合反应工程",
  "achievements": "荣誉获奖:\n获得国家科技进步二等奖1项，省部级科技进步奖6项。\n·学习及工作经历:\n1992.9－1996.7 中国纺织大学，化学纤维专业，本科\n1996.7－2001.7 东华大学（原中国纺织大学），材料学，硕博连读，工学博士\n2001.3—2005.8 东华大学环境学院环境科学系，讲师，副教授，主要研究聚酰胺、聚酯聚合反应工程及环境材料。 2005.9至今，东华大学材料学院高分子材料系，副研究员，主要研究纤维成形理论及加工技术，新产品开发等。\n·主要论文：\n[1]. Wang, C.S., Li M., Wang, H.P, Wang, X.Q., and Fantoni R.F. Monte Carlo Technique to Simulate Amide Interchange Reactions, 2. An Improved Model and PA6/PA66 Blend System, Iranian Polymer Journal. 2009,18(1): 49-61\n[2]. Zhu, X.L., Wang, B., Chen, S.Y., Wang, C.S., Zhang, Y.M., and Wang, H.P. Synthesis and Non-isothermal Crystallization Behavior of PET/surface-treated TiO2 Nanocomposites. Journal of Macromolecular Science, Part B: Physics. 2008, 47(6): 1117-1129\n[3]. Zhu, X.L., Wang,C.S., Wang, B., and Wang, H.P. Non-isothermal crystallization kinetics and nucleation activity of filler in polypropylene/microcrystalline cellulose composites. Iranian Polymer Journal. 2008,17(4) :297-309\n[4]. Zhang, C.X., Wang, H.P., and Wang, C.S*. Poly(trimethylene terephthalate) fiber melt-spinning:material parameters and computer simulation. Fibers and Polymers. 2007, 8(3):295\n[5]. Zhang, C.X., Wang, C.S., and Wang, H.P. Multifilament model of PET melt spinning and prediction of as-spun fiber's quality. Journal of Macromolecular Science, Part B: Physics. 2007, 46(4):793\n[6]. Lü, W.J., Zhu, X.L., Zhang, Y.M., Wang, H.P., Wang, C.S.*, and Ye, Y.T.  Crystallization behavior of rare-earth luminous polyamide 6 composites. Journal of Macromolecular Science, Part B: Physics. 2007, 46(5): 949\n[7]. Liu, Z.H., Wang, C.S.*, Wang, X.Q., Huang, N.X., and Fantoni, R.F. Monte carlo technique to simulate amide interchange reactions, influence of amide interchange reactions on molecular weight distribution. Macromolecular Theory and Simulations. 2005, 41:164\n[8]. Wang, C.S., Zhao, R.H., and Wang, H.P. Phenomenological Multifilament Model of PET Melt Spinning, The Fiber Society 2008 Fall Meeting and Technical Conference, Boucherville, Canada, Oct. 2008:114\n[9]. Wang C.S.*, Zhao R.-H, Han Q.-X., Zhang C.-X., Wang H.-P, Zhang Y., Xiao G., Dynamics model and simulation of polyethylene terephthalate (PET) hollow fiber, Journal of Donghua University, 2009,26(4): 387\n·授权的专利：\n获得授权国家发明专利6项、实用新型专利21项、软件著作权1项。\n·近几年承担的科研项目：主持和合作承担国家支撑计划、国家自然科学基金、中石化等重要项目10项和20余项横向项目。\n·国际交流与合作：\n2009.9-2010.9 美国佐治亚理工大学（Georgia Institute of Technology）访问学者\n·其他：\n1.“高导湿涤纶纤维制备关键技术及制品一条龙开发”，中国纺织工业协会科学技术奖一等奖, 2006年, 排名12/15\n2.“抗菌导湿腈纶纤维及混纺面料一条龙开发”，中国纺织工业协会科学技术奖二等奖，2006年, 排名7/9\n3.“高导湿涤纶纤维及制品关键技术集成开发”，国家科技进步二等奖, 2007年, 排名8/10\n4.“高品质熔体直纺超细旦涤纶长丝工业化生产技术集成开发”，中国纺织工业协会科学技术奖一等奖, 2008年, 排名4/10\n5.“新型差别化U形涤纶及其制品加工关键技术”，高等学校科学研究优秀成果奖科学技术进步奖二等奖，2008年，排名1/10\n6.“高性能稀土发光纤维的制备方法”，中国纺织工业协会科学技术奖三等奖，2009年, 排名3/7。\n7.“熔体直纺超细旦涤纶长丝关键技术”，高等学校科学研究优秀成果奖科学技术进步奖二等奖，2010年，排名5/15",
  "url": "https://cmse.dhu.edu.cn/fd/a0/c14707a196000/page.htm",
  "school": "东华大学",
  "college": "材料科学与工程学院",
  "city": "上海",
  "province": "上海",
  "photo": "https://cmse.dhu.edu.cn/_upload/article/images/8b/83/3f219cb24edfa2feca0cdcda1a3f/8f942438-3bca-4340-b454-bd8b4e43d41c.jpg"
 },
*
* */