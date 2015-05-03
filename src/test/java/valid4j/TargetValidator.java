package valid4j;


public class TargetValidator extends BaseValidator<Target>{

	@Override
	protected void validationDefinition() {
		helper.rejectIfEmpty(t->t.getName(), 1, "Name cannot be empty");
		helper.rejectIf(t->t.getAge()<=0, 2, "Age must be greater than zero");
	}
}
