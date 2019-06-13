package scenario

import io.gatling.core.Predef._
import _root_.chain.{AsLongAsChain, DoSwitchOrElseChain, ExtraInfoChain, FeederMoreThanValueChain, InjectionsChain, LoggerChain, NonSharedDataChain, OptionValidationChain, RandomSwitchChain, RepeatRandomValuesChain, TransformChain, TransformOptionChain, UserDependentDataChain}
import io.gatling.core.structure.ScenarioBuilder
import scenarios.ScenarioName

object ScenarioTest {

  val getRepeatRandomValues = scenario(ScenarioName.REPEAT_RANDOM_VALUE).exec(RepeatRandomValuesChain.getRandom)
  val getAsLongAs = scenario(ScenarioName.AS_LONG_AS).exec(AsLongAsChain.getAsLongAs)
  val getRandomSwitch = scenario(ScenarioName.RANDOM_SWITCH).exec(RandomSwitchChain.getRandomSwitch)
  val getDoSwitchOrElse = scenario(ScenarioName.DO_SWITCH_OR_ELSE).exec(DoSwitchOrElseChain.switchOrElse)
  val getFeederWithMoreThanOneValue = scenario(ScenarioName.FEEDER_MORE_THAN_VALUES).exec(FeederMoreThanValueChain.searchWithFeeder)
  val getUserDependentData = scenario(ScenarioName.USER_DEPENDENT_DATA).exec(UserDependentDataChain.getFilterURL)
  val getNonSharedData = scenario(ScenarioName.NON_SHARED_DATA).exec(NonSharedDataChain.scnFlattenFeederIntoAtributtes)
  val getTransformOption = scenario(ScenarioName.TRANSFORM_OPTION).exec(TransformOptionChain.useTransformOption)
  val getTransform = scenario(ScenarioName.TRANSFORM).exec(TransformChain.getRandomLink)
  val getOptionValidation = scenario(ScenarioName.OPTION_VALIDATION).exec(OptionValidationChain.useOptionValidation)
  val getHomePage = scenario(ScenarioName.HOME_PAGE).exec(InjectionsChain.goHomePage)
  val getHeaderInfo = scenario(ScenarioName.WRITE_HEADER_INFO).exec(LoggerChain.getHeader)
  val getLoggerExtraInfo = scenario(ScenarioName.LOGGER_EXTRA_INFO).exec(ExtraInfoChain.extraInfo)

  def getRandomPause(min: Int, max: Int): ScenarioBuilder = scenario(ScenarioName.RANDOM_PAUSE).exec(InjectionsChain.randomPause(min, max))

}



