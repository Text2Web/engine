function updateInputCount(input) {
    let inputValue = input.val()
    let count = input.closest(".form-group").find(".text-count-result")
    count.html("")
    count.html("Total Character: " + inputValue.length)
}

function initTagEditorTextCounter(targetForm) {
    let textCountInput = targetForm.find(".text-count")
    textCountInput.off();
    textCountInput.on("change paste keyup", function () {
        updateInputCount($(this))
    })

    textCountInput.each(function () {
        updateInputCount($(this))
    })
}

function initFormSubmit(modal) {
    let updateForm = modal.find("#update-form")
    updateForm.off();
    updateForm.on("click", function () {
        let form = modal.find("#meta-tag-editor");
        jQuery.ajax(
            {
                url: "/text2web-manage/update-seo-setting",
                data: form.serialize(),
                dataType: "json",
                method: "post",
                success: function (result) {
                    if (result.status === "success") {
                        modal.modal('hide')
                        let url = modal.attr("data-url");
                        window.location = url
                    }
                }
            }
        );
    })
}

jQuery(document).ready(function () {
    let modal = jQuery("#seo-editor-modal")

    jQuery("#click-edit-seo").click(function () {
        modal.modal({
            backdrop: 'static',
            keyboard: false
        });
    });

    modal.on('show.bs.modal', function (e) {
        let url = modal.attr("data-url");
        jQuery.ajax(
            {
                url: "/text2web-manage/load-seo-setting",
                data: {url: url},
                success: function (result) {
                    let editor = modal.find("#seo-editor");
                    editor.html("")
                    editor.html(result)
                    let metaTagEditor = jQuery("#meta-tag-editor")
                    initTagEditorTextCounter(metaTagEditor)
                    initFormSubmit(modal)
                }
            }
        );
    })



});