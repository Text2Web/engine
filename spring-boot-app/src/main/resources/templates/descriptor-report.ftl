<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Descriptor Report</title>
    <#include "common/common-header.ftl"/>
    <script src="/internal-asset/js/descriptor.js"></script>
</head>
<body>

<#include "common/header.ftl" />

<div class="container-fluid">
    <div class="row">

        <#assign activeNav = "descriptor-report">
        <#include "common/left-nav.ftl" />


        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
            <#include "common/flash.ftl" />
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                <h1 class="h2">Descriptor Report</h1>
            </div>

            <#if reports?has_content>
                <form action="/text2web-manage/merge-descriptor" method="post">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th class="text-center">
                                    <input class="form-check-input" type="checkbox" checked id="check-all"/>
                                    Merge
                                </th>
                                <th>Navigation Name</th>
                                <th>Navigation Identifier</th>
                                <th>Path</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tbody>
                            <#list reports as key, report>
                                <tr>
                                    <td class="text-center">
                                        <input class="form-check-input is-allowed-to-merge" type="checkbox" name="mergeData[${key}].isMerge" <#if report.isMerge>checked</#if>/>
                                        <input type="hidden"  name="mergeData[${key}].isMerge" value="false"/>
                                    </td>
                                    <#if report.isEditable>
                                        <td><input type="text" class="form-control change-in-input" name="mergeData[${key}].name" value="${ report.name }"/></td>
                                        <#else>
                                        <td>${ report.name?default("") }</td>
                                    </#if>

                                    <td>${ report.topicKey?default("") } <input type="hidden"  name="mergeData[${key}].topicKey" value="${ report.topicKey?default("") }"/></td>
                                    <td>${ report.relativePath?default("") } <input type="hidden"  name="mergeData[${key}].relativePath" value="${ report.relativePath?default("") }"/></td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <button type="submit" class="btn btn-primary">Merge</button>
                </form>
            <#else>
                <h3 class="h3 text-center">Reports not available</h3>
            </#if>

        </main>
    </div>
</div>

</body>
</html>