<template>
  <div>
    <!--  头部-->
    <div style="width: 1250px;margin: 10px 20px;">
      <el-steps :active="active" finish-status="success">
        <el-step title="考试信息"></el-step>
        <el-step title="设计试卷"></el-step>
        <el-step title="发布试卷"></el-step>
      </el-steps>
    </div>
<!-- 内容-->
    <div>
      <!--选项框-->
      <div style="width:99%;height: 50px;background-color: white;border: 1px solid gainsboro;margin-left: 10px; display: flex">
        <el-dropdown style="margin-top: 5px;margin-left: 5px">
          <el-button type="primary" size="big">
            创建试卷题目<i class="el-icon-arrow-down el-icon--right"></i>
          </el-button>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="v1">选择题</el-dropdown-item>
            <el-dropdown-item @click.native="v2">填空题</el-dropdown-item>
            <el-dropdown-item @click.native="v3">判断题</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <div style="flex:1"></div>
        <div style="margin-top: 15px;margin-right: 20px">
          一共<span style="color: red">{{totalNum}}</span>题,
          总分<span style="color: red">{{totalScore}}</span>分
        </div>
      </div>
      <!--选择题-->
      <div v-show="multiVisible">
        <div style="border: 1px solid gainsboro;margin-top: 10px;background-color: white;margin-left: 10px;"  >
<!--   操作框-->
        <div style="display: flex;border: 1px solid gainsboro;height: 35px">
          <div style="margin-top: 5px;margin-right: 20px">
            &nbsp;&nbsp;选择题&nbsp;&nbsp;&nbsp;<span class="el-icon-edit"></span>
            &nbsp;&nbsp;(<span style="color: red">{{multiNum}}</span>题,
            共<span style="color: red">{{multiScore}}</span>分)
          </div>
          <div style="flex:1"></div>
          <el-button size="mini" @click="selectMulti">从试题库中选</el-button>
          <el-button size="mini" @click="addMulti">新增试题</el-button>
        </div>
<!--表格-->
        <div style="margin-top: 10px;margin-left: 10px">
          <el-table :data="tableMulti" style="width: 100% ;" border>
            <el-table-column type="expand">
              <template slot-scope="props">
                <el-form label-position="left" inline class="demo-table-expand">
                  <el-form-item label="选项A：">
                    <span>{{ props.row.answerA }}</span>
                  </el-form-item>
                  <el-form-item label="选项B：">
                    <span>{{ props.row.answerB }}</span>
                  </el-form-item>
                  <el-form-item label="选项C：">
                    <span>{{ props.row.answerC }}</span>
                  </el-form-item>
                  <el-form-item label="选项D：">
                    <span>{{ props.row.answerD }}</span>
                  </el-form-item>
                  <el-form-item label="正确选项：">
                    <span>{{ props.row.rightAnswer }}</span>
                  </el-form-item>
                  <el-form-item label="章节：">
                    <span>{{ props.row.section }}</span>
                  </el-form-item>
                  <el-form-item label="解析：">
                    <span>{{ props.row.analysis }}</span>
                  </el-form-item>
                </el-form>
              </template>
            </el-table-column>
            <el-table-column
                label="题目ID"
                prop="questionId">
            </el-table-column>
            <el-table-column
                label="题目类型"
                prop="questionType">
            </el-table-column>
            <el-table-column
                label="试题内容"
                prop="question"
                width="600px"
            >
            </el-table-column>
            <el-table-column
                label="正确答案"
                prop="rightAnswer">
            </el-table-column>
            <el-table-column
                label="分数"
                prop="score">
              <template  slot-scope="scope">
                <el-input v-model="scope.row.score"
                          @change="changedMatNum(scope.$index,scope.row,$event)"
                          placeholder="请输入备注">
                </el-input>
              </template>
            </el-table-column>
            <el-table-column
                label="操作"
                width="200">
              <template slot-scope="scope">
                <el-button @click="handleEditMulti(scope.row)"  size="mini" >编辑</el-button>
                <template>
                  <el-popconfirm @confirm="handleDeleteMulti(scope.row,scope.$index)"
                                 title="确定删除吗？"
                  >
                    <!--   scope.row.id获取本列id     -->
                    <el-button   type="danger" slot="reference" size="mini" style="margin-left: 10px">删除</el-button>
                  </el-popconfirm>
                </template>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </div>
      </div>
      <!--填空题-->
      <div v-show="fillVisible">
        <div style="border: 1px solid gainsboro;margin-top: 10px;background-color: white;margin-left: 10px;"  >
          <!--   操作框-->
          <div style="display: flex;border: 1px solid gainsboro;height: 35px">
            <div style="margin-top: 5px;margin-right: 20px">
              &nbsp;&nbsp;填空题&nbsp;&nbsp;&nbsp;<span class="el-icon-edit"></span>
              &nbsp;&nbsp;(<span style="color: red">{{fillNum}}</span>题,
              共<span style="color: red">{{fillScore}}</span>分)
            </div>
            <div style="flex:1"></div>
            <el-button size="mini" @click="selectFill">从试题库中选</el-button>
            <el-button size="mini" @click="addFill">新增试题</el-button>
          </div>
          <!--表格-->
          <div style="margin-top: 10px;margin-left: 10px">
            <el-table :data="tableFill" style="width: 100% ;" border="true">
              <el-table-column type="expand">
                <template slot-scope="props">
                  <el-form label-position="left" inline class="demo-table-expand">
                    <el-form-item label="正确答案：">
                      <span>{{ props.row.answer }}</span>
                    </el-form-item>
                    <el-form-item label="章节：">
                      <span>{{ props.row.section }}</span>
                    </el-form-item>
                    <el-form-item label="解析：">
                      <span>{{ props.row.analysis }}</span>
                    </el-form-item>
                  </el-form>
                </template>
              </el-table-column>
              <el-table-column
                  label="题目ID"
                  prop="questionId">
              </el-table-column>
              <el-table-column
                  label="题目类型"
                  prop="questionType">
              </el-table-column>
              <el-table-column
                  label="试题内容"
                  prop="question"
                  width="600px"
                  :show-overflow-tooltip="true"
              >
              </el-table-column>
              <el-table-column
                  label="正确答案"
                  prop="answer"
                  :show-overflow-tooltip="true">
              </el-table-column>
              <el-table-column
                  label="分数"
                  prop="score">
                <template  slot-scope="scope">
                  <el-input v-model="scope.row.score"
                            @change="changedMatNum(scope.$index,scope.row,$event)"
                            placeholder="请输入备注">
                  </el-input>
                </template>
              </el-table-column>
              <el-table-column
                  label="操作"
                  width="200">
                <template slot-scope="scope">
                  <el-button @click="handleEditFill(scope.row)"  size="mini" >编辑</el-button>
                  <template>
                    <el-popconfirm @confirm="handleDeleteFill(scope.row,scope.$index)"
                                   title="确定删除吗？"
                    >
                      <!--   scope.row.id获取本列id     -->
                      <el-button   type="danger" slot="reference" size="mini" style="margin-left: 10px">删除</el-button>
                    </el-popconfirm>
                  </template>
                </template>
              </el-table-column>
            </el-table>
          </div>
        </div>
      </div>
      <!--判断题-->
      <div v-show="judgeVisible">
        <div style="border: 1px solid gainsboro;margin-top: 10px;background-color: white;margin-left: 10px;"  >
          <!--   操作框-->
          <div style="display: flex;border: 1px solid gainsboro;height: 35px">
            <div style="margin-top: 5px;margin-right: 20px">
              &nbsp;&nbsp;判断题&nbsp;&nbsp;&nbsp;<span class="el-icon-edit"></span>
              &nbsp;&nbsp;(<span style="color: red">{{judgeNum}}</span>题,
              共<span style="color: red">{{judgeScore}}</span>分)
            </div>
            <div style="flex:1"></div>
            <el-button size="mini" @click="selectJudge">从试题库中选</el-button>
            <el-button size="mini" @click="addJudge">新增试题</el-button>
          </div>
          <!--表格-->
          <div style="margin-top: 10px;margin-left: 10px">
            <el-table :data="tableJudge" style="width: 100% ;" border>
              <el-table-column type="expand">
                <template slot-scope="props">
                  <el-form label-position="left" inline class="demo-table-expand">
                    <el-form-item label="正确答案：">
                      <span>{{ props.row.answer }}</span>
                    </el-form-item>
                    <el-form-item label="章节：">
                      <span>{{ props.row.section }}</span>
                    </el-form-item>
                    <el-form-item label="解析：">
                      <span>{{ props.row.analysis }}</span>
                    </el-form-item>
                  </el-form>
                </template>
              </el-table-column>
              <el-table-column
                  label="题目ID"
                  prop="questionId">
              </el-table-column>
              <el-table-column
                  label="题目类型"
                  prop="questionType">
              </el-table-column>
              <el-table-column
                  label="试题内容"
                  prop="question"
                  width="600px"
              >
              </el-table-column>
              <el-table-column
                  label="正确答案"
                  prop="answer">
              </el-table-column>
              <el-table-column
                  label="分数"
                  prop="score">
                <template  slot-scope="scope">
                  <el-input v-model="scope.row.score"
                            @change="changedMatNum(scope.$index,scope.row,$event)"
                            placeholder="请输入备注">
                  </el-input>
                </template>
              </el-table-column>
              <el-table-column
                  label="操作"
                  width="200">
                <template slot-scope="scope">
                  <el-button @click="handleEditJudge(scope.row)"  size="mini" >编辑</el-button>
                  <template>
                    <el-popconfirm @confirm="handleDeleteJudge(scope.row,scope.$index)"
                                   title="确定删除吗？"
                    >
                      <!--   scope.row.id获取本列id     -->
                      <el-button   type="danger" slot="reference" size="mini" style="margin-left: 10px">删除</el-button>
                    </el-popconfirm>
                  </template>
                </template>
              </el-table-column>
            </el-table>
          </div>
        </div>
      </div>
    </div>
    <!--      弹出修改选择题对话框-->
    <el-dialog title="修改选择题题目信息" :visible.sync="dialogMultiVisible" width="80%"  top="5vh" center="true">
      <el-form :model="formMulti" label-width="80px">
        <el-form-item label="题目内容" style="width: 100%">
          <el-input v-model="formMulti.question" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="选项A" style="width: 100%">
          <el-input v-model="formMulti.answerA" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="选项B" style="width: 100%">
          <el-input v-model="formMulti.answerB" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="选项C" style="width: 100%">
          <el-input v-model="formMulti.answerC" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="选项D" style="width: 100%">
          <el-input v-model="formMulti.answerD" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="正确答案" style="width: 100%">
          <el-input v-model="formMulti.answer" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分数" style="width: 100%">
          <el-input v-model="formMulti.score" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="科目" style="width: 100%">
          <el-input v-model="formMulti.subject" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="难度水平" style="width: 100%">
          <el-input v-model="formMulti.level" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分析" style="width: 100%">
          <el-input v-model="formMulti.analysis" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogMultiVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveMulti">确 定</el-button>
      </div>
    </el-dialog>
    <!--      弹出修改填空题对话框-->
    <el-dialog title="修改题目信息" :visible.sync="dialogJudgeVisible" width="80%"  top="5vh" center="true">
      <el-form :model="formJudge" label-width="80px">
        <el-form-item label="题目内容" style="width: 100%">
          <el-input v-model="formJudge.question" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="正确答案" style="width: 100%">
          <el-input v-model="formJudge.answer" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分数" style="width: 100%">
          <el-input v-model="formJudge.score" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="科目" style="width: 100%">
          <el-input v-model="formJudge.subject" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="章节" style="width: 100%">
          <el-input v-model="formJudge.section" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="难度水平" style="width: 100%">
          <el-input v-model="formJudge.level" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分析" style="width: 100%">
          <el-input v-model="formJudge.analysis" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogJudgeVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveJudge">确 定</el-button>
      </div>
    </el-dialog>
    <!--      弹出修改选择题对话框-->
    <el-dialog title="修改题目信息" :visible.sync="dialogFillVisible" width="80%"  top="5vh" center="true">
      <el-form :model="formFill" label-width="80px">
        <el-form-item label="题目内容" style="width: 100%">
          <el-input v-model="formFill.question" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="正确答案" style="width: 100%">
          <el-input v-model="formFill.answer" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分数" style="width: 100%">
          <el-input v-model="formFill.score" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="科目" style="width: 100%">
          <el-input v-model="formFill.subject" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="章节" style="width: 100%">
          <el-input v-model="formFill.section" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="难度水平" style="width: 100%">
          <el-input v-model="formFill.level" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分析" style="width: 100%">
          <el-input v-model="formFill.analysis" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFillVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveFill">确 定</el-button>
      </div>
    </el-dialog>

    <!--从试题库中导入试题-->
    <!-- Table1 -->
    <el-dialog title="从题库中选择" :visible.sync="dialogSelectVisible1" width="90%" top="5vh" center="true">
      &nbsp;

      <span style="margin-left: 50px">试题难度：</span><el-select placeholder="选择题目难度" v-model="selectValueLevel1" >
      <el-option label="" value=""></el-option>
      <el-option label="容易" value="容易"></el-option>
        <el-option label="中等" value="中等"></el-option>
        <el-option label="困难" value="困难"></el-option>
      </el-select>

      <span style="margin-left: 50px">关键字搜索： </span>
      <el-input style="width: 200px" placeholder="请输入题目关键字" v-model="keyword1"></el-input>
      <el-button @click="loadMulti" type="primary" style="margin-left: 100px" >查询</el-button>
      <el-table
          :row-key="rowKeyMulti"
          border="true"
          ref="multipleTable"
          :data="tableQuestion1"
          tooltip-effect="dark"
          style="width: 100%;margin-top: 10px"
          @selection-change="handleSelectionChange1">
        <el-table-column
            type="selection"
            width="55"
            :reserve-selection="true">
        </el-table-column>
        <el-table-column
            label="试题内容"
            prop="question"
            width="360"
            :show-overflow-tooltip="true"
            :reserve-selection="true">
        </el-table-column>
        <el-table-column
            prop="questionType"
            label="题型"
            width="120"
            :reserve-selection="true">
        </el-table-column>
        <el-table-column
            prop="level"
            label="试题难度"
            width="120"
            :reserve-selection="true">
        </el-table-column>
        <el-table-column
            prop="answer"
            label="正确答案"
            width="120"
            :reserve-selection="true">
        </el-table-column>

        <el-table-column
            prop="score"
            label="默认分数"
            width="120"
            :reserve-selection="true">
        </el-table-column>
        <el-table-column
            prop="createTime"
            label="创建时间"
            show-overflow-tooltip
            :reserve-selection="true"
        >
        </el-table-column>
      </el-table>
      <div style="margin: 10px 0">
        <el-pagination
            @size-change="handleSizeChange1"
            @current-change="handleCurrentChange1"
            :current-page="currentPage1"
            :page-sizes="[5, 10]"
            :page-size="pageSize1"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total1">
        </el-pagination>
      </div>
    </el-dialog>
    <!-- Table2 -->
    <el-dialog title="从题库中选择" :visible.sync="dialogSelectVisible2" width="90%" top="5vh" center="true">
      <span style="margin-left: 50px">试题难度：</span><el-select placeholder="选择题目难度" v-model="selectValueLevel2" >
        <el-option label="容易" value="容易"></el-option>
        <el-option label="中等" value="中等"></el-option>
        <el-option label="困难" value="困难"></el-option>
      </el-select>

      <span style="margin-left: 50px">关键字搜索： </span>
      <el-input style="width: 200px" placeholder="请输入题目关键字" v-model="keyword2"></el-input>
      <el-button @click="loadFill" type="primary" style="margin-left: 100px">查询</el-button>
      <el-table
          :row-key="rowKeyFill"
          border="true"
          ref="multipleTable"
          :data="tableQuestion2"
          tooltip-effect="dark"
          style="width: 100%;margin-top: 10px"
          @selection-change="handleSelectionChange2">
        <el-table-column
            type="selection"
            width="55"
            :reserve-selection="true">
        </el-table-column>
        <el-table-column
            label="试题内容"
            prop="question"
            width="360"
            :show-overflow-tooltip="true"
            :reserve-selection="true"
        >
        </el-table-column>
        <el-table-column
            prop="questionType"
            label="题型"
            width="120"
            :reserve-selection="true">
        </el-table-column>
        <el-table-column
            prop="level"
            label="试题难度"
            width="120"
            :reserve-selection="true">
        </el-table-column>
        <el-table-column
            prop="answer"
            label="正确答案"
            width="120"
            :show-overflow-tooltip="true"
            :reserve-selection="true">
        </el-table-column>

        <el-table-column
            prop="score"
            label="默认分数"
            width="120"
            :reserve-selection="true">
        </el-table-column>
        <el-table-column
            prop="createTime"
            label="创建时间"
            show-overflow-tooltip
            :reserve-selection="true"
        >
        </el-table-column>
      </el-table>
      <div style="margin: 10px 0">
        <el-pagination
            @size-change="handleSizeChange2"
            @current-change="handleCurrentChange2"
            :current-page="currentPage2"
            :page-sizes="[5, 10]"
            :page-size="pageSize2"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total2">
        </el-pagination>
      </div>
    </el-dialog>
    <!-- Table3 -->
    <el-dialog title="从题库中选择" :visible.sync="dialogSelectVisible3" width="90%" top="5vh" center="true">
          <span style="margin-left: 50px">试题难度：</span><el-select placeholder="选择题目难度" v-model="selectValueLevel3" >
      <el-option label="容易" value="容易"></el-option>
      <el-option label="中等" value="中等"></el-option>
      <el-option label="困难" value="困难"></el-option>
    </el-select>

      <span style="margin-left: 50px">关键字搜索： </span>
      <el-input style="width: 200px" placeholder="请输入题目关键字" v-model="keyword3"></el-input>
      <el-button @click="loadJudge" type="primary" style="margin-left: 100px">查询</el-button>
      <el-table
          :row-key="rowKeyJudge"
          border="true"
          ref="multipleTable"
          :data="tableQuestion3"
          tooltip-effect="dark"
          style="width: 100%;margin-top: 10px"
          @selection-change="handleSelectionChange3">
        <el-table-column
            type="selection"
            width="55"
            :reserve-selection="true">
        </el-table-column>
        <el-table-column
            label="试题内容"
            prop="question"
            width="360"
            :show-overflow-tooltip="true"
            :reserve-selection="true">
        </el-table-column>
        <el-table-column
            prop="questionType"
            label="题型"
            width="120"
            :reserve-selection="true">
        </el-table-column>
        <el-table-column
            prop="level"
            label="试题难度"
            width="120"
            :reserve-selection="true">
        </el-table-column>
        <el-table-column
            prop="answer"
            label="正确答案"
            width="120"
            :reserve-selection="true">
        </el-table-column>

        <el-table-column
            prop="score"
            label="默认分数"
            width="120"
            :reserve-selection="true">
        </el-table-column>

        <el-table-column
            prop="createTime"
            label="创建时间"
            show-overflow-tooltip
            :reserve-selection="true"
        >
        </el-table-column>
      </el-table>
      <div style="margin: 10px 0">
        <el-pagination
            @size-change="handleSizeChange3"
            @current-change="handleCurrentChange3"
            :current-page="currentPage3"
            :page-sizes="[5, 10]"
            :page-size="pageSize3"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total3">
        </el-pagination>
      </div>
    </el-dialog>

    <div style="width: 100%;position: fixed;bottom: 0px;background-color: whitesmoke">
      <el-button type="primary" style="margin-left: 450px;width: 150px" @click="last" >上一步</el-button>
      <el-button type="primary" style="width: 150px" @click="next" >完成&去发布试卷</el-button>
    </div>
  </div>
</template>

<script>

import request from "@/utils/request";

export default {
  name: "DesignPaper",
  data(){
    return{
      /*选择题题库信息*/
      dialogSelectVisible1:false,
      selectValueLevel1:'',
      keyword1:'',
      tableQuestion1:[{}],
      currentPage1:1,
      pageSize1:5,
      total1:0,
      /*填空题题库*/
      dialogSelectVisible2:false,
      selectValueLevel2:'',
      keyword2:'',
      tableQuestion2:[{}],
      currentPage2:1,
      pageSize2:5,
      total2:0,
      /*判断题题库*/
      dialogSelectVisible3:false,
      selectValueLevel3:'',
      keyword3:'',
      tableQuestion3:[{}],
      currentPage3:1,
      pageSize3:5,
      total3:0,
      /*基本信息*/
      multiNum:0,   //选择题数量
      fillNum:0,    //填空题数量
      judgeNum:0,   //判断题数量
      totalNum:0,   //题目总数
      multiScore:0, //选择题分数
      fillScore:0,  //填空题分数
      judgeScore:0, //判断题分数
      totalScore:0, //题目总分数
      active:1,     //激活状态
      dialogMultiVisible:false,//修改选择题弹出框的可见性
      dialogJudgeVisible:false,//修改判断题弹出框的可见性
      dialogFillVisible:false,//修改填空题题弹出框的可见性
      dialogSelectVisible:false,//从从题库中选择题目框可见性
      multiVisible:false, //选择题div可视否
      fillVisible:false,  //填空题div可视否
      judgeVisible:false, //判断题div可视否
      formMulti:{},       //修改选择题表单
      formFill:{},        //修改填空题表单
      formJudge:{},       //修改判断题表单
      tableMulti:'',
      tableFill:'',//填空题表
      tableJudge:'',//判断题表
      multipleSelection: [],
    }
  },
  created() {
    /*this.changedMatNum()*/
    this.loadMulti();
    this.loadFill();
    this.loadJudge();
    this.changedMatNum();
  },
  methods:{
    loadMulti(){
        /*选择题*/
      request.get("/api/multiQuestion/allMulti",{
        params:{
          pageNum:this.currentPage1,
          pageSize:this.pageSize1,
          keyWord:this.keyword1,
          level:this.selectValueLevel1
        }
      }).
      then(resp=>{
        this.tableQuestion1 = resp.data.records
        this.total1 = resp.data.total
      })
    },
    /*选择题*/
    handleSizeChange1(pageSize){
      this.pageSize1 =pageSize;
      this.loadMulti()
    },
    handleCurrentChange1(pageNum){
      this.currentPage1 = pageNum;
      this.loadMulti()
    },
    rowKeyMulti(row) {
      // console.log('================:', JSON.stringify(row))
      return row.questionId
    },
    handleSelectionChange1(val){
      this.tableMulti = val;
      this.changedMatNum();
    },
    //编辑试卷选择题
    handleEditMulti(row){
      this.dialogMultiVisible = true;
      this.formMulti =JSON.parse(JSON.stringify(row));
      console.log(row)
    },
    //删除试卷选择题
    handleDeleteMulti(data,index){
      this.tableMulti.splice(index,1);
      this.changedMatNum();
    },
    //保存修改的选择题
    saveMulti(){
      this.dialogMultiVisible = false;
    },
    //从题库中选择选择题
    selectMulti(){
      this.dialogSelectVisible1 =true;
    },
    //手动添加选择题
    addMulti(){},

    /*填空题*/
    //从题库中选择填空题
    selectFill(){
      this.dialogSelectVisible2 =true;
    },
    loadFill(){
      /*填空题*/
      request.get("/api/fillQuestion/allFill",{
        params:{
          pageNum:this.currentPage2,
          pageSize:this.pageSize2,
          keyWord:this.keyword2,
          level:this.selectValueLevel2
        }
      }).
      then(resp=>{
        this.tableQuestion2 = resp.data.records
        this.total2 = resp.data.total
      })
    },
    rowKeyFill(row){
      return row.questionId
    },
    handleSelectionChange2(val){
      this.tableFill = val;
      this.changedMatNum();
    },
    handleSizeChange2(pageSize){
      this.pageSize2 =pageSize;
      this.loadFill()
    },
    handleCurrentChange2(pageNum){
      this.currentPage2 = pageNum;
      this.loadFill()
    },
    //编辑试卷填空题
    handleEditFill(row){
      this.dialogFillVisible = true;
      this.formFill =JSON.parse(JSON.stringify(row));
      console.log(row)
    },
    //删除试卷填空题
    handleDeleteFill(data,index){
      this.tableFill.splice(index,1);
      this.changedMatNum();
    },
    //保存修改的填空题
    saveFill(){
      this.dialogFillVisible = false;
    },
    //手动添加填空题
    addFill(){},
    /*判断题*/
    //从题库中选择判断题
    selectJudge(){
      this.dialogSelectVisible3 =true;
    },
    loadJudge(){
      /*填空题*/
      request.get("/api/judgeQuestion/allJudge",{
        params:{
          pageNum:this.currentPage3,
          pageSize:this.pageSize3,
          keyWord:this.keyword3,
          level:this.selectValueLevel3
        }
      }).
      then(resp=>{
        this.tableQuestion3 = resp.data.records
        this.total3 = resp.data.total
      })
    },
    rowKeyJudge(row){
      return row.questionId
    },
    handleSelectionChange3(val){
      this.tableJudge= val;
      this.changedMatNum();
    },
    handleSizeChange3(pageSize){
      this.pageSize3 =pageSize;
      this.loadJudge()
    },
    handleCurrentChange3(pageNum){
      this.currentPage3 = pageNum;
      this.loadJudge()
    },
    //编辑试卷判断题
    handleEditJudge(row){
      this.dialogJudgeVisible = true;
      this.formJudge =JSON.parse(JSON.stringify(row));
      console.log(row)
    },
    //删除试卷判断题
    handleDeleteJudge(data,index){
      this.tableJudge.splice(index,1);
      this.changedMatNum();
    },
    //保存修改的判断题
    saveJudge(){
      this.dialogJudgeVisible = false;
    },
    //手动添加判断题
    addJudge(){},

    /*======其他=====*/
    last(){
      this.$router.back('/examInfo')
    },
    next(){
      //提交整个题目
      alert("确认要提交吗？")
      this.$router.push('/completeDesign')
      let questionId= new Array();
      let score = new Array();

      for(let i=0;i<this.tableMulti.length+this.tableFill.length+this.tableJudge.length;i++){
        if(i<this.tableMulti.length){
          questionId[i] = this.tableMulti[i].questionId;
          score[i] = this.tableMulti[i].score;
        }else if(i>=this.tableMulti.length && i<this.tableMulti.length+this.tableFill.length){
          questionId[i] = this.tableFill[i-this.tableMulti.length].questionId;
          score[i] = this.tableFill[i-this.tableMulti.length].score
        }else{
          let j = i-this.tableMulti.length-this.tableFill.length
          questionId[i] =  this.tableJudge[j].questionId
          score[i] = this.tableJudge[j].score
        }
        console.log(questionId[i])
        console.log(score[i])
      }
      request.post("api/paperManage",questionId).
      then(resp=>{
        console.log(resp)
      })
      request.post("api/paperManage/score",score).
      then(resp=>{
        console.log(resp)
      })
      console.log(this.tableMulti)
    },
    //显示div
    v1(){
      this.multiVisible = true;
      this.fillVisible = false;
      this.judgeVisible = false;
    },
    v2(){
      this.multiVisible = false;
      this.fillVisible = true;
      this.judgeVisible = false;
    },
    v3(){
      this.multiVisible = false;
      this.fillVisible = false;
      this.judgeVisible = true ;
    },
    //总分
    changedMatNum(){
      //遍历显示分数
      let index1 = 0;
      let scores1 = 0;
      // while (this)
      while (this.tableMulti.length>index1){
        scores1 += parseInt(this.tableMulti[index1].score)
        index1++;
      }
      this.multiScore = scores1;

      let index2 = 0;
      let scores2 = 0;
      // while (this)
      while (this.tableFill.length>index2){
        scores2 += parseInt(this.tableFill[index2].score)
        index2++;
      }
      this.fillScore = scores2;
      let index3 = 0;
      let scores3 = 0;
      // while (this)
      while (this.tableJudge.length>index3){
        scores3 += parseInt(this.tableJudge[index3].score)
        index3++;
      }
      this.judgeScore = scores3;
      this.totalScore = scores1 +scores2 +scores3;
      this.multiNum =this.tableMulti.length;
      this.fillNum =this.tableFill.length;
      this.judgeNum =this.tableJudge.length;
      this.totalNum = this.tableMulti.length+this.tableJudge.length+this.tableFill.length


    },
  },


}
</script>
<style scoped>
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
</style>