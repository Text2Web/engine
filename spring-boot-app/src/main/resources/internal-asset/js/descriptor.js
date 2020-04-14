jQuery(document).ready(function () {
    let checkAll = jQuery("#check-all")
    let individualCheck = jQuery(".is-allowed-to-merge")
    individualCheck.on("change", function () {
        checkAll.attr("checked", false)
    })

    checkAll.on("click", function () {
        if ($(this).prop("checked") === true) {
            checkUncheck(true);
        } else if ($(this).prop("checked") === false) {
            checkUncheck(false);
        }
    })

    let inputBox = jQuery(".change-in-input")
    inputBox.on("change", function () {
        $(this).closest("tr").find(".is-allowed-to-merge").prop("checked", true)
    })


    function checkUncheck(isChecked) {
        individualCheck.each(function () {
            $(this).prop("checked", isChecked)
        })
    }
})