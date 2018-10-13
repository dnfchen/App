<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/header.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
    <div class="col-md-12 col-xs-12 col-sm-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>查看并审核APP信息 <i class="fa fa-user"></i><small>管理员1</small></h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_title">
                <h2>APP基础信息</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content1">
                <form action="#" class="form-horizontal form-label-left" method="post">
                    <input type="hidden" name="" value="">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">软件名称 <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" value="" class="form-control col-md-7 xol-xs-12" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">APK名称 <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" value="" class="form-control col-md-7 xol-xs-12" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">支持ROM <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" value="" class="form-control col-md-7 xol-xs-12" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">界面语言 <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" value="" class="form-control col-md-7 xol-xs-12" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">软件大小 <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" value="" class="form-control col-md-7 xol-xs-12" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">下载次数 <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" value="" class="form-control col-md-7 xol-xs-12" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台 <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" value="" class="form-control col-md-7 xol-xs-12" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">所属分类 <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" value="软件--> 办公--> 文档" class="form-control col-md-7 xol-xs-12" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态 <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" value="" class="form-control col-md-7 xol-xs-12" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">应用简介 <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" value="" class="form-control col-md-7 xol-xs-12" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">LOGO图片 <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            暂无
                            <img src="" alt="" width="100%">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <button type="submit" name="status" value="2" class="btn btn-success">审核通过</button>
                            <button type="submit" name="status" value="3" class="btn btn-success">审核不通过</button>
                            <button type="button" class="btn btn-primary">返回</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->
<!-- footer content -->
<%@ include file="common/footer.jsp"%>
<!-- /footer content -->