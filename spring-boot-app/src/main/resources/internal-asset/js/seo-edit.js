function updateInputCount(input) {
    let inputValue = input.val()
    let count = input.closest(".form-group").find(".text-count-result")
    count.html("")
    count.html("Total Character: " + inputValue.length)
}

function initTagEditorTextCounter(targetForm) {
    let textCountInput = targetForm.find(".text-count")
    textCountInput.on("change paste keyup", function () {
        updateInputCount($(this))
    })

    textCountInput.each(function () {
        updateInputCount($(this))
    })
}

function initFormSubmit(modal) {
    modal.find("#update-form").on("click", function () {
        let form = modal.find("#meta-tag-editor");
        jQuery.ajax(
            {
                url: "/text2web-manage/update-seo-setting",
                data: form.serialize(),
                method: "post",
                success: function (result) {
                    console.log(result)
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
        jQuery.ajax(
            {
                url: "/text2web-manage/load-seo-setting",
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