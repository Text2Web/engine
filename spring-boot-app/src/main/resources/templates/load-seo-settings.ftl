<div class="container-fluid">
    <form id="meta-tag-editor" method="post" action="/text2web-manage/update-seo-setting">
        <div class="form-group">
            <label>Page Title</label>
            <input type="tel" name="title" class="form-control text-count">
            <small class="form-text text-muted text-count-result" >Total Character: 0</small>
        </div>
        <#list seo.tags as tag>
            <div class="card" style="margin-top: 5px">
                <div class="card-body">
                    <h5 class="card-title">Tag Name: <strong>${tag.name}</strong></h5>
                    <input type="hidden" name="tags[${tag?index}].name" value="${tag.name}">
                    <#list tag.attrs as key, value>
                        <div class="form-group">
                            <label>Attribute Name: <span class="text-danger">${key}</span></label>
                            <#if key == "content">
                                <textarea name="tags[${tag?index}].attrs[${key}]" class="form-control text-count">${value}</textarea>
                            <#else>
                                <input name="tags[${tag?index}].attrs[${key}]" type="text" class="form-control text-count" value="${value}">
                            </#if>
                            <small class="form-text text-muted text-count-result" >Total Character: 0</small>
                        </div>
                    </#list>

                </div>
            </div>
        </#list>
    </form>
</div>
