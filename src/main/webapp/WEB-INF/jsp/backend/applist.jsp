<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/header.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
    <div class="row">
        <div class="col-md-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>APP 审核列表 <i class="fa fa-user"></i> <smail>管理员1</smail> -
                    您可以通过搜索或者其他的筛选项对APP的信息系统进行审核操作。^_^</h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <form action="#" method="post">
                        <input type="hidden" name="" value="">
                        <ul>
                            <li>
                                <div class="form-group">
                                    <lable class="col-md-3 col-sm-3 col-xs-12">软件名称</lable>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="form-group">
                                    <lable class="col-md-3 col-sm-3 col-xs-12">所属平台</lable>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select name="" class="form-control">
                                            <option value="">--请选择--</option>
                                        </select>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="form-group">
                                    <lable class="col-md-3 col-sm-3 col-xs-12">一级分类</lable>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select name="" class="form-control">
                                            <option value="">--请选择--</option>
                                        </select>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="form-group">
                                    <lable class="col-md-3 col-sm-3 col-xs-12">二级分类</lable>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select name="" class="form-control">
                                            <option value="">--请选择--</option>
                                        </select>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="form-group">
                                    <lable class="col-md-3 col-sm-3 col-xs-12">三级分类</lable>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select name="" class="form-control">
                                            <option value="">--请选择--</option>
                                        </select>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <button type="submit" class="btn btn-primary">查&nbsp;&nbsp;&nbsp;&nbsp;询</button>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_content">
                    <div class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                        <div class="row">
                            <div class="col-sm-12">
                                <table class="table table-striped table-bordered">
                                    <thead>
                                    <tr>
                                        <th>软件名称</th>
                                        <th>APK名称</th>
                                        <th>软件大小(单位：M)</th>
                                        <th>所属平台</th>
                                        <th>所属分类(一级分类、二级分类、三级分类)</th>
                                        <th>状态</th>
                                        <th>下载次数</th>
                                        <th>最新版本号</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr role="row" class="odd">
                                        <td>软件名称</td>
                                        <td>APK名称</td>
                                        <td>软件大小(单位：M)</td>
                                        <td>所属平台</td>
                                        <td>所属分类(一级分类、二级分类、三级分类)</td>
                                        <td>状态</td>
                                        <td>下载次数</td>
                                        <td>最新版本号</td>
                                        <td>
                                            <button type="button" class="btn btn-default"
                                            data-toggle="tooltip" title="查看并审核APP">
                                                审核
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-5">
                                <div class="dataTables_info" role="status">共10条记录
                                    2/5页
                                </div>
                            </div>
                            <div class="col-sm-7">
                                <div class="dataTables_paginate">
                                    <ul class="pagination">
                                        <li class="paginate_button"><a href="#">首页</a></li>
                                        <li class="paginate_button"><a href="#">上一页</a></li>
                                        <li class="paginate_button"><a href="#">下一页</a></li>
                                        <li class="paginate_button"><a href="#">最后一页</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->
<!-- footer content -->
<%@ include file="common/footer.jsp"%>
<!-- /footer content -->